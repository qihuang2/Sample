package com.android.rnm.bustime.utils.rv;


import java.util.List;

public class SimpleBindingAdapter extends BindingAdapter {

    private List<BaseListItem> mItemList;

    public SimpleBindingAdapter(){

    }

    public void setItemList(List<BaseListItem> baseListItems){
        this.mItemList = baseListItems;
    }

    @Override
    public BaseListItem getListItem(int position) {
        return mItemList.get(position);
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }
}
