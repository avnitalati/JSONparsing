package com.example.hp.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String json="{" +
          "      'glossary':{\n" +
           "     \"title\": \"example glossary\",\n" +
           "         \"GlossDiv\": {\n" +
            "    \"title\": \"S\",\n" +
            "            \"GlossList\": {\n" +
             "   \"GlossEntry\": {\n" +
             "           \"ID\": \"SGML\",\n" +
             "                   \"SortAs\": \"SGML\",\n" +
             "                  \"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
              "                  \"Acronym\": \"SGML\",\n" +
              "                  \"Abbrev\": \"ISO 8879:1986\",\n" +
               "                 \"GlossDef\": {\n" +
               "           \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
               "                     \"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
                "        },\n" +
                 "       \"GlossSee\": \"markup\"\n" +
                 "   }" +
               " }" +
           " }" +
       " }" +
       " }" ;
        try {
            JsonDemo(json);

        } catch (JSONException e)
            {
                e.printStackTrace();
            }
        }


    public void JsonDemo(String json) throws JSONException {

        JSONObject mainobj=new JSONObject(json);
        JSONObject subobj=mainobj.getJSONObject("glossary");

        String title=subobj.getString("title");
        Log.d("myApp","sub title:"+title);

        JSONObject subsubobj=subobj .getJSONObject("glossdiv");
        String subtitle=subsubobj.getString("title");
        Log.d("myApp","sub title:"+title);

        JSONObject listobj=subsubobj.getJSONObject("glossList");
        JSONObject entryobj=listobj .getJSONObject("GlossList");
        String sortas=entryobj .getString("SortAs");
        String glossterm=entryobj .getString("GlossTerm");
        String acronym=entryobj .getString("Acronym");
        String abbrev=entryobj .getString("Abbrebv");

        JSONObject defobj=new JSONObject("glossdef");
        String para=defobj .getString("para");

        JSONArray seealso=defobj .optJSONArray("glossseeAlso");
        String gml=seealso.getString(1);
        String xml=seealso.getString(2);

        String glossseeobj=entryobj .getString("glossSee");

    }
    }





