package com.example.tae.second_assignment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tae.second_assignment.LocalDB.RealmController.RealmController;
import com.example.tae.second_assignment.network.model.Music_Model;
import com.example.tae.second_assignment.network.model.OnItemClickListener;
import com.example.tae.second_assignment.network.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.realm.Realm;

/**
 * Created by TheAppExperts on 27/09/2017.
 */

class MusicAdapter extends RecyclerView.Adapter <MusicAdapter.RockMusicViewHolder>{


    List<Result> rockListModels;
    int row;
    Context applicationContext;
    private final OnItemClickListener listener;
    Realm realm;
    RealmController controller;
    Music_Model musicModel;
    Result result;

    public MusicAdapter(List<Result> rockListModels, int row, OnItemClickListener listener, Context applicationContext) {
        this.rockListModels = rockListModels;
        this.listener = listener;

        this.row=row;
        this.applicationContext=applicationContext;
    }

    @Override
    public RockMusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(row, null);
        return new RockMusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RockMusicViewHolder holder, int position) {
        holder.bind(rockListModels.get(position), listener);
        holder.tvArtist.setText(rockListModels.get(position).getArtistName());
        holder.tvCollection.setText(rockListModels.get(position).getCollectionName());
        holder.tvTrackPrice.setText(rockListModels.get(position).getTrackPrice().toString());
        Picasso.with(applicationContext)
                .load(rockListModels.get(position).getArtworkUrl60())
                .resize(500, 500)
                .centerCrop()
                .into(holder.imgMovie);
        Log.i("~~~~~~~~~~~~~~~~~~~~~","Recieved Data");
    //    Realm.init(applicationContext);
        realm=Realm.getDefaultInstance();
        realm.beginTransaction();
//        controller=new RealmController(realm);
      for (int i = 0; i <rockListModels.size(); i++)
        {
           result= rockListModels.get(i);
           Log.i("saveDB", "saving artist name *********** = " + result.getArtistName().toString() );
//         controller.saveResult(result);
        realm.copyToRealm(result);

        }
        realm.commitTransaction();
    }

    @Override
    public int getItemCount() {
        return rockListModels.size();
    }

    public class RockMusicViewHolder extends RecyclerView.ViewHolder{

        TextView tvArtist, tvTrackPrice, tvCollection;
        ImageView imgMovie;

        public RockMusicViewHolder(View itemView) {
            super(itemView);

            tvArtist= (TextView) itemView.findViewById(R.id.title);
            tvTrackPrice = (TextView) itemView.findViewById(R.id.subtitle);
            imgMovie = (ImageView) itemView.findViewById(R.id.movie_iv);
            tvCollection =(TextView)itemView.findViewById(R.id.description);
        }
        public void bind(final Result item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }

    }
}
