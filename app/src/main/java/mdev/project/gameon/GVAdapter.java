package mdev.project.gameon;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GVAdapter extends ArrayAdapter<DataModal> {

    // constructor for our list view adapter.
    public GVAdapter(@NonNull Context context, ArrayList<DataModal> dataModalArrayList) {
        super(context, 0, dataModalArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // below line is use to inflate the
        // layout for our item of list view.
        View listitemView = convertView;
      if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.image_gv_item, parent, false);
        }

        // after inflating an item of listview item
        // we are getting data from array list inside
        // our modal class.
        DataModal dataModal = getItem(position);

        // initializing our UI components of list view item.
        Button nameTV = listitemView.findViewById(R.id.idTVtext);
        ImageView courtIV = listitemView.findViewById(R.id.idIVimage);
        // after initializing our items we are
        // setting data to our view.
        // below line is use to set data to our text view.
        nameTV.setText(dataModal.getName());

        // in below line we are using Picasso to load image
        // from URL in our Image VIew.
        Picasso.with(getContext()).load(dataModal.getImgUrl()).into(courtIV);

        // below line is use to add item
        // click listener for our item of list view.
        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on the item click on our list view.
                // we are displaying a toast message.
                //Toast.makeText(getContext(), "Item clicked is : " + dataModal.getName(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getContext(),BookingScreen.class);
                i.putExtra("extra", nameTV.getText());
                getContext().startActivity(i);


            }
        });

        nameTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on the item click on our list view.
                // we are displaying a toast message.
                //Toast.makeText(getContext(), "Item clicked is : " + dataModal.getName(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getContext(),BookingScreen.class);
                i.putExtra("extra", nameTV.getText());
                getContext().startActivity(i);


            }
        });
        return listitemView;
    }
}
