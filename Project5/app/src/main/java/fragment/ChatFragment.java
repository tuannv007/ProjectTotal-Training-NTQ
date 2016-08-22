package fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import key.api.KeyParam;
import key.api.listconversation.KeyListConversation;
import my.item.ItemSearchFriendListview;
import myadapter.ChatContentAdapter;
import user.User;

/**
 * Created by admin on 7/29/2016.
 */
public class ChatFragment extends BaseFragment implements View.OnClickListener {
    private ArrayList<User> arrChat = new ArrayList<>();
    private ChatContentAdapter myAdapter;
    private ImageView imvDelete;
    private ImageView imvDone;
    private TextView txtContentDelete;
    private ListView listView;
    private String jsonData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chat_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
      /*  initData();*/
/*
        new ChatAsyncTask().execute();
*/
        getData();
        myAdapter = new ChatContentAdapter(getActivity(), arrChat);
        listView.setAdapter(myAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).hideActionbar();
    }

    private void initView(View view) {
        listView = (ListView) view.findViewById(R.id.lv_chat);
        imvDelete = (ImageView) view.findViewById(R.id.imv_delete_chat_history);
        imvDone = (ImageView) view.findViewById(R.id.imv_menu_done);
        txtContentDelete = (TextView) view.findViewById(R.id.txt_delete);

        imvDone.setOnClickListener(this);
        imvDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imv_delete_chat_history:
                myAdapter.isDelete = true;
                imvDelete.setVisibility(View.GONE);
                imvDone.setVisibility(View.VISIBLE);
                txtContentDelete.setText(R.string.done);
                break;
            case R.id.imv_menu_done:
                myAdapter.isDelete = false;
                imvDelete.setVisibility(View.VISIBLE);
                imvDone.setVisibility(View.GONE);
                txtContentDelete.setText(R.string.deleteHistory);
                break;
        }
        myAdapter.notifyDataSetChanged();
    }
    private void getData(){
        HashMap<String, Object> object = new HashMap<>();
        String file =readJsonInFile();
        RequestQueue mRequestQueue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest request = new JsonObjectRequest(file, new JSONObject(object),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("tagSearchSetting", response.toString());
                        JSONObject jsonObject = response;
                        try {
                            String frd_id = jsonObject.getString(KeyListConversation.keyIdFriend);
                            String frd_name = jsonObject.getString(KeyListConversation.keyFriendName);
                            int gender = Integer.parseInt(jsonObject.getString(KeyListConversation.keyGender));
                            boolean is_online = Boolean.parseBoolean(jsonObject.getString(KeyListConversation.keyOnline));
                            String ava_id = jsonObject.getString(KeyListConversation.keyAvatarId);
                            String last_msg = jsonObject.getString(KeyListConversation.keyLastMessage);
                            String is_own = jsonObject.getString(KeyListConversation.keyIsOwn);
                            String sent_time = jsonObject.getString(KeyListConversation.keySendTime);
                            String unread_num = jsonObject.getString(KeyListConversation.keyUnreadNum);
                            String longs = jsonObject.getString(KeyListConversation.keyLong);
                            String lat = jsonObject.getString(KeyListConversation.keyLat);
                            String dist = jsonObject.getString(KeyListConversation.keyDistance);
                            String msg_type = jsonObject.getString(KeyListConversation.keyMessageType);
                            User user = new User(frd_id,ava_id,last_msg,is_own,sent_time,unread_num,longs,lat,dist,msg_type,frd_name,gender,is_online);
                            arrChat.add(user);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });

        mRequestQueue.add(request);
    }

    /*private class ChatAsyncTask extends AsyncTask<String, Void, ArrayList<User>> {

        @Override
        protected ArrayList<User> doInBackground(String... params) {
            // read file in folder assets (not json call apo from internet)
            readJsonInFile();
            return arrChat;
        }

        @Override
        protected void onPostExecute(ArrayList<User> users) {
            super.onPostExecute(users);
            String outputData = "";
            // declare Object JSON
            JSONObject jsonResponse;

            try {
                // lead to file json
                jsonResponse = new JSONObject(jsonData);
                // initialization object Json Array. input JSONArray. if object is JsonObject then initialization object JsonObject
                JSONArray jsonMainNode = jsonResponse.optJSONArray(KeyListConversation.keyJsonArray);
                // get length JsonArray
                int lengthJsonArr = jsonMainNode.length();
                // for length arrayJson
                for (int i = 0; i < lengthJsonArr; i++) {
                    JSONObject jsonObject = jsonMainNode.getJSONObject(i);
                    //get value in jSonObject
                    String frd_id = jsonObject.getString(KeyListConversation.keyIdFriend);
                    String frd_name = jsonObject.getString(KeyListConversation.keyFriendName);
                    int gender = Integer.parseInt(jsonObject.getString(KeyListConversation.keyGender));
                    boolean is_online = Boolean.parseBoolean(jsonObject.getString(KeyListConversation.keyOnline));
                    String ava_id = jsonObject.getString(KeyListConversation.keyAvatarId);
                    String last_msg = jsonObject.getString(KeyListConversation.keyLastMessage);
                    String is_own = jsonObject.getString(KeyListConversation.keyIsOwn);
                    String sent_time = jsonObject.getString(KeyListConversation.keySendTime);
                    String unread_num = jsonObject.getString(KeyListConversation.keyUnreadNum);
                    String longs = jsonObject.getString(KeyListConversation.keyLong);
                    String lat = jsonObject.getString(KeyListConversation.keyLat);
                    String dist = jsonObject.getString(KeyListConversation.keyDistance);
                    String msg_type = jsonObject.getString(KeyListConversation.keyMessageType);

                    User user = new User(frd_id,ava_id,last_msg,is_own,sent_time,unread_num,longs,lat,dist,msg_type,frd_name,gender,is_online);
                    arrChat.add(user);
                    //Log.i("JSON parse", song_name);
                }
            } catch (JSONException e) {
                Log.d("Parsing error", e.toString());
            }

        }
    }*/

    private String readJsonInFile() {
        try {
            InputStream is = getActivity().getAssets().open("user.txt");
            int size = is.available();
            byte data[] = new byte[size];
            is.read(data);
            is.close();

            jsonData = new String(data); //jsonData chứa dữ liệu đọc từ file
        } catch (Exception e) {
            Log.d("Reading error", e.toString());
        }
        return jsonData;
    }
}
