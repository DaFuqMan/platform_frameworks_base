package com.android.systemui.tuner;

import android.content.Context;
import android.provider.Settings;
import android.util.AttributeSet;

import com.android.systemui.statusbar.phone.QSTileHost;

public class QSPagingSwitch extends TunerSwitch {

    public static final String QS_PAGE_TILES =
            "dwifi,dbt,dnd,cell,battery,user,rotation,flashlight,location,"
             + "hotspot,qwifi,qbt,qlock,qflashlight,qairplane,inversion,cast";

    public QSPagingSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean persistBoolean(boolean value) {
        Settings.Secure.putString(getContext().getContentResolver(), QSTileHost.TILES_SETTING,
                value ? QS_PAGE_TILES : "default");
        return super.persistBoolean(value);
    }

}
