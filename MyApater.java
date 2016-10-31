package com.sanayq.androidmysql1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**MyApater
 * Created by Admin on 03.03.2016.
 */
public class MyApater extends  RecyclerView.Adapter<MyApater.ViewHolder> implements View.OnClickListener {
    public static int getItem;
    private List<ProductRetrofit> mDataset;
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
        public TextView qty;
        public TextView price;
        public ImageView imageView;
        public View view;
        public ViewHolder(View v) {
            super(v);
            view=v;
            name = (TextView) v.findViewById(R.id.tvName);
            price = (TextView) v.findViewById(R.id.tvPrice);
            qty = (TextView) v.findViewById(R.id.tvQty);
            imageView = (ImageView) v.findViewById(R.id.imageView);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyApater(List<ProductRetrofit> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyApater.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                  int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_layout, parent, false);
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
        holder.name.setText(mDataset.get(position).name);
        holder.price.setText(mDataset.get(position).price);
        holder.qty.setText(mDataset.get(position).qty);

        Glide.with(holder.imageView.getContext())
                .load(mDataset.get(position).image_url)
                .into(holder.imageView);
        holder.itemView.setTag(R.id.item_tag, position);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
