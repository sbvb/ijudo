package br.pl.iJudo.ui;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import br.pl.iJudo.R;

/**
 * Created by yuri on 17/05/16.
 */
public class MySimpleExpandableListAdapter extends SimpleExpandableListAdapter {

    public MySimpleExpandableListAdapter(Context context,
                                         List<? extends Map<String, ?>> groupData, int groupLayout,
                                         String[] groupFrom, int[] groupTo,
                                         List<? extends List<? extends Map<String, ?>>> childData,
                                         int childLayout, String[] childFrom, int[] childTo) {
        super(context, groupData, groupLayout, groupFrom, groupTo, childData,
                childLayout, childFrom, childTo);
        // TODO Auto-generated constructor stub
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent)
    {
        final View itemRenderer = super.getChildView(groupPosition, childPosition, isLastChild, convertView, parent);
        final TextView tv3 = (TextView)itemRenderer.findViewById(R.id.textchild);
        //tv2.setTextColor(0xff0000ff);
        //tv3.setGravity(Gravity.CENTER);
        return itemRenderer;
    }

    @Override
    public  View    getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent){

        final View itemRenderer = super.getGroupView(groupPosition, isExpanded, convertView, parent);
        final TextView tv = (TextView)itemRenderer.findViewById(R.id.texttitle1);

                //tv.setTextColor(0xff6A1B9A); //tv.setTextSize(24); //tv.setGravity(Gravity.CENTER); //tv.setBackgroundColor(0xffff0000);

        final TextView tv2 = (TextView)itemRenderer.findViewById(R.id.texttitle2);
        //tv2.setGravity(Gravity.CENTER); //tv2.setBackgroundColor(0xffff0000);


        return itemRenderer;
    }
}