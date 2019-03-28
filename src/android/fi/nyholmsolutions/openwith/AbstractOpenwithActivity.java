package fi.nyholmsolutions.openwith;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

abstract class AbstractOpenwithActivity extends Activity {
    @Override
    protected void onCreate(final Bundle state) {
        super.onCreate(state);
        final Intent intent = this.getIntent();
        final Intent newIntent = new Intent(this, com.hatsa.app.MainActivity.class);
        newIntent.setAction(intent.getAction());
        newIntent.setFlags(intent.getFlags());
        newIntent.setDataAndType(intent.getData(), intent.getType());
        newIntent.setClipData(intent.getClipData());
        newIntent.putExtras(intent);
        newIntent.putExtra("destination", getDestination());
        startActivity(newIntent);
    }

    protected abstract String getDestination();
}
