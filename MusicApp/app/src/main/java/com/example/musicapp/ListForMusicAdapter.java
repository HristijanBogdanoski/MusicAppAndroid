package com.example.musicapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;

public class ListForMusicAdapter extends RecyclerView.Adapter<ListForMusicAdapter.ViewHolder>{
    ArrayList<AudioModel> songsList;
    Context context;
    public ListForMusicAdapter(ArrayList<AudioModel> songsList, Context context) {
        this.songsList = songsList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recylcler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        int position;
        AudioModel songData = songsList.get(position);
        holder.NaslovtextView.setText(songData.getTitle());

        if(InstanceHolder.currIndex==position){
            holder.NaslovtextView.setTextColor(Color.parseColor("#FF0000"));
        }else {
            holder.NaslovtextView.setTextColor(Color.parseColor("#000000"));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InstanceHolder.getInstance().reset();
                InstanceHolder.currIndex = position;
                Intent intent = new Intent(context,MusicPlayerActivity.class);
                intent.putExtra("LIST",songsList);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView NaslovtextView;
        ImageView IconView;
        public ViewHolder(View itemView) {
            super(itemView);
            NaslovtextView=itemView.findViewById(R.id.music_title_text);
            IconView =itemView.findViewById(R.id.icon_view);

        }
    }
}
