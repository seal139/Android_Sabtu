package com.septianPramana.latihan2a.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;

import com.septianPramana.latihan2a.ContactDetail;
import com.septianPramana.latihan2a.Model.Contact;
import com.septianPramana.latihan2a.R;

import java.io.File;

public class ContactView extends AbstractView<Contact> {

    public ContactView(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void onDataFilled() {
        CardView cardId = itemView.findViewById(R.id.contact_view);

        TextView name = itemView.findViewById(R.id.contact_name);
        TextView address = itemView.findViewById(R.id.contact_address);


        name.setText(getEntity().getName());
        address.setText(getEntity().getAddress() + " - " + getEntity().getCity() + "\n(" + getEntity().getPhone() + ")");

        ImageView img = itemView.findViewById(R.id.contact_picture);
        
        img.setImageDrawable(getEntity().getImg());

        cardId.setOnClickListener(v -> {
               System.out.println(getEntity().getName());
               Intent detailView = new Intent(v.getContext(), ContactDetail.class);
               detailView.putExtra("contactObj", getEntity());

               v.getContext().startActivity(detailView);
            }
        );



    }
}
