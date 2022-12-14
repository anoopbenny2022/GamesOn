package portfolio.project.gameon;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Locale;


public class BookingCourt extends AppCompatActivity implements PaymentResultListener {

    Button btPay;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    TextView priceText;
    Button timeButton;
    int hour, minute;
    Button cancel;
    String name;
    String state;
    String about;
    String price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_court2);
        /*cancel = findViewById(R.id.bt_pay2);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BookingCourt.this,CourtDetails.class);
                startActivity(i);
            }
        });*/
        name = getIntent().getStringExtra("Name");
        state = getIntent().getStringExtra("State");
        about = getIntent().getStringExtra("About");
        price = getIntent().getStringExtra("Price");
        //For time picker
        timeButton = findViewById(R.id.timeButton);
        priceText = findViewById(R.id.textView4);
        TextView courtName = findViewById(R.id.textView6);
        courtName.setText(name);
        // For date picker
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());
        priceText.setText(price);

        // for razor pay
        btPay = findViewById(R.id.bt_pay);
        String sAmount=price.replace("$","");
        int amount=Math.round(Float.parseFloat(sAmount)*100);
        btPay.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view)
                                     {
                                         Checkout checkout = new Checkout();
                                         checkout.setKeyID("rzp_live_iZOjirYZ6WPXbF");
                                         checkout.setImage(com.razorpay.R.drawable.rzp_logo);
                                         JSONObject object = new JSONObject();
                                         try {
                                             object.put("name", "GameOn");
                                             object.put("description", "Payment");
                                            // object.put("theme.color", "317ECC");
                                             object.put("currency","USD");
                                             object.put("amount",amount);
                                             object.put("prefill.contact","9267445883");
                                             object.put("prefill.email","androidtest@gmail.com");
                                             checkout.open(BookingCourt.this,object);
                                         } catch (JSONException e) {
                                             e.printStackTrace();
                                         }
                                     }
                                 }
        );

        cancel = findViewById(R.id.bt_pay2);
        cancel.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view)
                                     {
                                         Intent i = new Intent(BookingCourt.this,CourtDetails.class);
                                         i.putExtra("Name",name);
                                         i.putExtra("About", about);
                                         i.putExtra("State", state);
                                         i.putExtra("Price", price);
                                         startActivity(i);
                                     }
                                 }
        );
    }

// for razor pay
    @Override
    public void onPaymentSuccess(String s) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Payment ID");
        builder.setMessage(s);
        builder.show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(),"Unable to process payment. Please try again",Toast.LENGTH_SHORT).show();

    }


// For date picker
    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month) {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = 3;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }
// Time picker
public void popTimePicker(View view)
{
    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
    {
        @Override
        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
        {
            hour = selectedHour;
            minute = selectedMinute;
            timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
        }
    };

    //int style =3;

    TimePickerDialog timePickerDialog = new TimePickerDialog(this,/* style,*/ onTimeSetListener, hour, minute, true);

    timePickerDialog.setTitle("Select Time");
    timePickerDialog.show();
}
}

