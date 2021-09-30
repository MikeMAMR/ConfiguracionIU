package com.example.configuracion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import java.awt.font.NumericShaper;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
        //OPCIONES DE LA APLICACION
        SwitchPreferenceCompat premiumPref = findPreference("premium");
        if(premiumPref != null){
            premiumPref.setSummaryProvider(new Preference.SummaryProvider() {
                @Override
                public CharSequence provideSummary(Preference preference) {
                    if(premiumPref.isChecked()){
                        return "Habilitado";
                    }
                    return "No habilitado";
                }
            });

        }
        //OPCIONES DE USUARIO
        SwitchPreferenceCompat swtchPreference = findPreference("notifications");
        SwitchPreferenceCompat mostrarPreference = findPreference("mostrar");

        EditTextPreference numberPreference = findPreference("number");
        EditTextPreference correoPreference = findPreference("correo");
        EditTextPreference nombrePreference = findPreference("nombre");


        if(mostrarPreference != null){
            mostrarPreference.setSummaryProvider(new Preference.SummaryProvider() {
                @Override
                public CharSequence provideSummary(Preference preference) {
                    if(mostrarPreference.isChecked()){
                        numberPreference.setVisible(true);
                        correoPreference.setVisible(true);
                        nombrePreference.setVisible(true);
                        return "Habilitado";

                    }else{
                        numberPreference.setVisible(false);
                        correoPreference.setVisible(false);
                        nombrePreference.setVisible(false);
                        return "No habilitado";
                    }
                }
            });
        }


        if (numberPreference != null) {
            numberPreference.setOnBindEditTextListener(
                    new EditTextPreference.OnBindEditTextListener() {
                        @Override
                        public void onBindEditText(@NonNull EditText editText) {
                            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                        }
                    }
            );
            numberPreference.setSummaryProvider(new Preference.SummaryProvider<EditTextPreference>() {
                @Override
                public CharSequence provideSummary(EditTextPreference preference) {
                    String text = preference.getText();
                    if(TextUtils.isEmpty(text)){
                        return "Vacio";
                    }else{
                        return text.toString();
                    }
                }

            });
        }
        if (correoPreference != null) {
            correoPreference.setOnBindEditTextListener(
                    new EditTextPreference.OnBindEditTextListener() {
                        @Override
                        public void onBindEditText(@NonNull EditText editText) {
                            editText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                        }
                    }
            );
            correoPreference.setSummaryProvider(new Preference.SummaryProvider<EditTextPreference>() {
                @Override
                public CharSequence provideSummary(EditTextPreference preference) {
                    String text = preference.getText();
                    if(TextUtils.isEmpty(text)){
                        return "Vacio";
                    }else{
                        return text.toString();
                    }
                }

            });
        }
        if (nombrePreference != null) {

            nombrePreference.setSummaryProvider(new Preference.SummaryProvider<EditTextPreference>() {
                @Override
                public CharSequence provideSummary(EditTextPreference preference) {
                    String text = preference.getText();
                    if(TextUtils.isEmpty(text)){
                        return "Vacio";
                    }else{
                        return text.toString();
                    }
                }

            });
        }



        //Preference webpagePreference = findPreference("webpage");
        //Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setData(Uri.parse("https://www.tabnine.com/code/java/methods/androidx.preference.SwitchPreferenceCompat/setChecked"));
        //webpagePreference.setIntent(intent);







    }
}