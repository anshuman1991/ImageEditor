package com.anshuman.imageeditor;

import android.app.Application;

import com.aviary.android.feather.sdk.IAviaryClientCredentials;

/**
 * Created by aagnihotri on 09/03/15.
 */
public class EditingApplication extends Application implements IAviaryClientCredentials {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public String getBillingKey() {
        return ""; // leave it blank
    }

    @Override
    public String getClientID() {
        return "d1a84990c7c448bf8147b4c5b3c4ac19";
    }

    @Override
    public String getClientSecret() {
        return "9b8041ae-330b-4c83-9714-55f0413ee311";
    }
}