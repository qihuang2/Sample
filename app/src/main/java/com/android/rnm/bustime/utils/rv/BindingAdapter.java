package com.android.rnm.bustime.utils.rv;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.rnm.bustime.BR;


public abstract class BindingAdapter extends RecyclerView.Adapter<BindingAdapter.BindableViewHolder>{

    public abstract BaseListItem getListItem(int position);

    @NonNull
    @Override
    public BindableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BindableViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BindableViewHolder holder, int position) {
        holder.bindViewModel(getListItem(position));
    }

    @Override
    public int getItemViewType(int position) {
        return getListItem(position).getLayout();
    }


    public static class BindableViewHolder extends RecyclerView.ViewHolder{

        protected ViewDataBinding viewDataBinding;

        public BindableViewHolder(ViewDataBinding itemBinding) {
            super(itemBinding.getRoot());
            this.viewDataBinding = itemBinding;
        }

        public void bindViewModel(BaseListItem viewModel){
            viewDataBinding.setVariable(BR.item, viewModel);
        }
    }
}
