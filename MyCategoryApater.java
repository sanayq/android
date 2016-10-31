package com.sanayq.androidmysql1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**MyApater
 * Created by Admin on 03.03.2016.
 */
public class MyCategoryApater extends  RecyclerView.Adapter<MyCategoryApater.ViewHolder> implements View.OnClickListener {
    public static int getItem;
    private List<CategoryRetrofit> mDataset;
    OnItemClickListener mOnItemClickListener;//храним обработчик нажатий

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }


    @Override
    public void onClick(View v) {       //когда нажали объект адаптера
        int position = (int) v.getTag(R.id.item_tag);
        if (mOnItemClickListener != null) { //если есть обработчик нажатия - то запускаем его
            mOnItemClickListener.onItemClick(mDataset.get(position), position);
        }
    }

    public interface OnItemClickListener<T> {//интерфейс работы нажатия

        void onItemClick(T item, int position);
    }
    public static void getItem(int position) {
    }

    // Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name;
        public View view;
        public ViewHolder(View v) {
            super(v);
            view=v;
            name = (TextView) v.findViewById(R.id.tvName);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyCategoryApater(List<CategoryRetrofit> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyCategoryApater.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                  int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        v.setOnClickListener(this);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.name.setText(mDataset.get(position).categor);
        holder.itemView.setTag(R.id.item_tag, position);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
