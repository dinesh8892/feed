package com.example.feed.Adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.feed.R;
import com.example.feed.model.Author;
import com.example.feed.model.Item;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {


    private Context context;
    private List<Item> items;

    public PostAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.post_card_view, viewGroup, false);
        return new PostViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {

        Item item = items.get(i);

        Document document = Jsoup.parse(item.getContent());
        postViewHolder.post_description.setText(document.text());

        Elements elements = document.select("img");
        if (elements.size() != 0) {
            postViewHolder.post_image.setVisibility(View.VISIBLE);
            Glide.with(context).load(elements.get(0).attr("src")).into(postViewHolder.post_image);
        }
        Author author = item.getAuthor();
        postViewHolder.trainer_name.setText(author.getDisplayName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        ImageView trainer_image;
        TextView trainer_name;
        ImageView post_image;
        TextView post_description;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            trainer_image = itemView.findViewById(R.id.trainer_profile_pic);
            trainer_name = itemView.findViewById(R.id.trainer_name);

            post_image = itemView.findViewById(R.id.card_img);
            post_description = itemView.findViewById(R.id.description);
        }
    }
}
