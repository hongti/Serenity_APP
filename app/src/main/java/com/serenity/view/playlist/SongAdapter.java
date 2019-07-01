package com.serenity.view.playlist;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.serenityapp.R;
import com.serenity.model.Song;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private List<Song> songList;
    private TextView stateTitleText;
    private TextView stateInfoText;
    public String uri;
    public String name;
    public String singer;
    private ImageView stateImageView;
    private int position;

    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void onClick(View view, int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View songView;
        TextView titleText;
        TextView infoText;
        public ViewHolder(View view){
            super(view);
            songView = view;
            titleText = view.findViewById(R.id.song_item_title);
            infoText = view.findViewById(R.id.song_item_info);
        }
    }

    public SongAdapter(List<Song> songList){
        this.songList = songList;
        this.position = -1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View parentView = (View) parent.getParent();
        stateTitleText = parentView.findViewById(R.id.play_list_state_title_text);
        stateInfoText = parentView.findViewById(R.id.play_list_state_info_text);
        stateImageView = parentView.findViewById(R.id.play_list_state_image);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_play, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.titleText.setText(song.getName());
        holder.infoText.setText(song.getSinger());
        if(onItemClickListener != null) {
            if(position == this.position){
                holder.titleText.setTextColor(R.color.colorThemeOrange);
                holder.infoText.setTextColor(R.color.colorThemeOrange);
                name = song.getName();
                singer = song.getSinger();
                uri = song.getUri();
                stateTitleText.setText(name);
                stateInfoText.setText(singer);
                stateImageView.setImageBitmap(song.getAlbumImage());
            }
            else{
                holder.titleText.setTextColor(Color.WHITE);
                holder.infoText.setTextColor(Color.WHITE);
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onClick(view, holder.getLayoutPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public int getPosition(){
        return this.position;
    }
    public void setPosition(int position){
        this.position = position;
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
}