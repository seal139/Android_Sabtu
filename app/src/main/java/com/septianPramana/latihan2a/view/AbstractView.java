package com.septianPramana.latihan2a.view;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class AbstractView<T> extends RecyclerView.ViewHolder{

    private T entity;
    public AbstractView(@NonNull View itemView) {
        super(itemView);
    }

    public void setEntity(T entity){
        this.entity = entity;
    }

    public T getEntity(){
        return this.entity;
    }

    public abstract void onDataFilled();
}
