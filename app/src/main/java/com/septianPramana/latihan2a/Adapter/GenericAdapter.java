package com.septianPramana.latihan2a.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.septianPramana.latihan2a.view.AbstractView;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericAdapter<T, V extends AbstractView<T>> extends RecyclerView.Adapter<V> {
    private final List<T> dataList = new ArrayList<>();

    private final int resUi;
    private final Class<V> view;

    public GenericAdapter(@LayoutRes int ui, Class<V> viewClass){
        this.resUi = ui;
        this.view = viewClass;
    }
    private CardView cardId;


    public void addItem(T item){
        dataList.add(item);
    }

    public void addItems(Collection<T> items){
        items.forEach(v -> dataList.add(v));
    }

    public void removeItem(T item){
        dataList.remove(item);
    }

    protected V viewInitializer(View view) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        return (V)this.view.getDeclaredConstructor(View.class).newInstance(view);
    }

    @NonNull
    @Override
    public V onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resUi, parent, false);
        try {
            return viewInitializer(view);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException  | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull V holder, int position) {
        holder.setEntity(dataList.get(position));
        holder.onDataFilled();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
