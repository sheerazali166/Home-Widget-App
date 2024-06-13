package com.example.homewidgetapp;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * Created by Sheeraz on 6/14/2024.
 */

public class WidgetContactProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        final int N = appWidgetIds.length;

        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i = 0; i < N; i++) {

            int appWidgetId = appWidgetIds[i];

            RemoteViews mViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);

            //create an intent reference WidgetService
            Intent intent = new Intent(context, WidgetService.class);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);

            intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
            mViews.setRemoteAdapter(appWidgetId, R.id.contactListView, intent);
            appWidgetManager.updateAppWidget(appWidgetId, mViews);

        }

        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}
