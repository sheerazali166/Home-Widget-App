package com.example.homewidgetapp;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by Sheeraz on 6/14/2024.
 */

public class WidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {

        WidgetRemoteViewsFactory dataProvider = new WidgetRemoteViewsFactory(getApplicationContext(), intent);

        return dataProvider;
    }
}
