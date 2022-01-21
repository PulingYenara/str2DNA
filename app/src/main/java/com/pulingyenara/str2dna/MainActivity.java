package com.pulingyenara.str2dna;
 
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends Activity { 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		Button b_toDNA = findViewById(R.id.toDNA);
		final EditText e_in = findViewById(R.id.input);
		final EditText e_out = findViewById(R.id.output);
		
		b_toDNA.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1) {
					String input_str = e_in.getText().toString();
					char[] input_chars = input_str.toCharArray();
					ArrayList<String> input_str_hex = toUnicodeBin(input_chars);
					
					StringBuilder sb = new StringBuilder();
					for(String str : input_str_hex){
						if(str.equals("0")){
							sb.append("A");
						}
						else{
						sb.append(str);
						}
					}
					String out = sb.toString();
					e_out.setText(out);
				}
		});
    }
	
	public ArrayList<String> toUnicodeBin(char[] data){
		ArrayList<String> result = new ArrayList<String>();
		for(char c : data){
			result.add(Integer.toBinaryString(c));
		}
		return result;
	}
} 
