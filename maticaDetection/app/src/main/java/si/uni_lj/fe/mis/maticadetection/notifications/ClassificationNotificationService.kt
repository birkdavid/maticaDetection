package si.uni_lj.fe.mis.maticadetection.notifications

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import si.uni_lj.fe.mis.maticadetection.MainActivity
import si.uni_lj.fe.mis.maticadetection.R

class ClassificationNotificationService(private val context: Context) {

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


    fun showNotification(animal: String){
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val notification = NotificationCompat.Builder(context, CLASSIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_android_black_24dp)
            .setContentTitle("Matica classification")

            .setContentText("Queen bee status: $animal")  //detected oz. not detected

            .setContentIntent(activityPendingIntent)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(
            1,notification
        )
    }

    companion object{
        const val CLASSIFICATION_CHANNEL_ID = "classification_channel"
    }
}