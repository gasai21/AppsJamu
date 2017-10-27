package com.example.pangling.appsjamu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pangling.appsjamu.MainActivity;
import com.example.pangling.appsjamu.R;
import com.example.pangling.appsjamu.model.Bekas;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Pangling on 10/26/2017.
 */
public class RecycleViewAdapterHistory extends RecyclerView.Adapter<RecycleViewAdapterHistory.ViewHolder> {

    private Context context;
    private List<Bekas> histories;

    public RecycleViewAdapterHistory(Context context, List<Bekas> histories) {
        this.context = context;
        this.histories = histories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_history, parent, false);
        ViewHolder holder3 = new ViewHolder(v);

        return holder3;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Bekas mhs = histories.get(position);
        String ucr = mhs.getUsername();
        if(ucr.equals(MainActivity.ambilId)) {
            holder.textViewNIM.setText(mhs.getTgl());
            holder.textViewNama.setText(mhs.getKonsultasi());
        }else{

        }
    }

    @Override
    public int getItemCount() {
        return  histories == null ? 0 : histories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.txtDate)TextView textViewNIM;
        @BindView(R.id.txtIsi)TextView textViewNama;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            /*String nim = textViewNIM.getText().toString();
            String nama = textViewNama.getText().toString();


            Intent i = new Intent(context, UpdateActivity.class);
            i.putExtra("nim",nim);
            i.putExtra("nama",nama);
            context.startActivity(i);*/

        }

    }
}
