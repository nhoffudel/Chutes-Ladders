package edu.udel.ckcamp.extremechutesandladders;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class PopupMenu implements OnItemClickListener {
    private Context context;
    private ListView options;
    private String header;
    private OnItemClickListener listener;
    private AlertDialog dialog;
    
    public PopupMenu(Context context, String header, String[] menuOptions,
                     OnItemClickListener listener, int textSize) {
        this.setContext(context);
        this.options = new ListView(context);
        this.options.setAdapter(new SimpleTextViewArrayAdapter<String>(context, menuOptions, textSize));
        this.options.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        this.options.setOnItemClickListener(this);
        this.setHeader(header);
        this.listener = listener;
        
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(header);
        builder.setView(options);
        dialog = builder.create();
    }
    
    public void show() {
        dialog.show();
    }
    
    /**
     * Pass the event on the the listener and then close the dialog
     */
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        listener.onItemClick(parent, view, position, id);
        dialog.dismiss();
    }

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
}
