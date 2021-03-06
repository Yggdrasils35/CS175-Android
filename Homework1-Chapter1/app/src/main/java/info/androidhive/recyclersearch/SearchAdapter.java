package info.androidhive.recyclersearch;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private List<Search> mSearchList;



    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView searchText;
        TextView searchId;
        public OnItemClickListener mOnItemClickListener;

        public ViewHolder(View view, OnItemClickListener mListener)
        {
            super(view);
            view.setOnClickListener(this);
            this.mOnItemClickListener = mListener;
            searchText = (TextView) view.findViewById(R.id.search_text);
            searchId = (TextView) view.findViewById(R.id.search_id);
        }

        @Override
        public void onClick(View v)
        {
            mOnItemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public SearchAdapter(List <Search> searchList){
        mSearchList = searchList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item,parent,false);
        ViewHolder holder = new ViewHolder(view, myClickItemListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position){
        Search search = mSearchList.get(position);
        holder.searchText.setText(search.getText());
        holder.searchId.setText(String.valueOf(search.getId()));
    }

    @Override
    public int getItemCount(){
        return mSearchList.size();
    }

//=======================click===================================

    // 自定义回调接口
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
        void onItemLongClick(View v);
    }

    public OnItemClickListener myClickItemListener;

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.myClickItemListener = listener;
    }
}
