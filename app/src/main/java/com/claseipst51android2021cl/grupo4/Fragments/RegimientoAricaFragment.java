package com.claseipst51android2021cl.grupo4.Fragments;
//Libreria de dialog fragment
import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class RegimientoAricaFragment extends DialogFragment {

    public static final String ARGUMENTO_TITTLE = "TITLE";
    public static final String ARGUMENTO_FULL_SNIPPET = "FULL_SNIPPET";

    public  String title;
    public  String fullSnippet;

    public static RegimientoAricaFragment newIntance(String title, String fullSnippet){
        RegimientoAricaFragment fragment = new RegimientoAricaFragment();
        Bundle b = new Bundle();
        b.putString(ARGUMENTO_TITTLE, title);
        b.putString(ARGUMENTO_FULL_SNIPPET, fullSnippet);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();

        title = args.getString(ARGUMENTO_TITTLE);
        fullSnippet = args.getString(ARGUMENTO_FULL_SNIPPET);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog =  new AlertDialog.Builder(getActivity()).setTitle(title).setMessage(fullSnippet).create();
        return dialog;
    }
}