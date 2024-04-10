package com.example.ommafood;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Esmt Dakar and move the camera
        LatLng bidew = new LatLng(14.669597150546366, -17.43541762459781);
        mMap.addMarker(new MarkerOptions().position(bidew).title("Bidew").snippet("Contact: 338231909, Site: bidew.sn"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bidew, 14));



        LatLng tai = new LatLng(14.693388782956678, -17.460318490608554);
        mMap.addMarker(new MarkerOptions().position(tai).title("Taillandais").snippet("Contact: 338255833, Site: https://www.jardin-thailandais.com/"));

        LatLng fouchette  = new LatLng(14.671735475062807, -17.428022438381483);
        mMap.addMarker(new MarkerOptions().position(fouchette).title("La fourchette").snippet("Contact: 338426666, Site: https://linktr.ee/groupelafourchette"));


        LatLng ucad = new LatLng(14.68142184965503, -17.437768890409814);
        mMap.addMarker(new MarkerOptions().position(ucad).title("Relais de Paris Dakar").snippet("Contact: 338233000"));

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        CircleOptions co = new CircleOptions()
                .center(bidew)
                .radius(600)
                .fillColor(Color.GREEN)
                .strokeColor(Color.BLACK)
                .strokeWidth(6);
        mMap.addCircle(co);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                if(marker.getTitle().equals("ESMT")){
                    //Faire un call pour faire un appel auto : ACTION.CALL
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:786088248"));
                    startActivity(intent);
                }

                if(marker.getTitle().equals("UCAD")){
                    //Faire un sms
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:786088248"));
                    intent.putExtra("sms_body", "Bonjour");
                    startActivity(intent);
                }
                return false;
            }
        });

    }
}