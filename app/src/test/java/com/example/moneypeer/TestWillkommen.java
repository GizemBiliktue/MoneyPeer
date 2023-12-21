package com.example.moneypeer;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.content.Intent;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.test.core.app.ActivityScenario;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class TestWillkommen {

    EditText mockEditNameText;
    Toast mockToast;
    Intent mockIntent;

    Button mockButton;
    private WillkommenActivity willkommenActivity;

    @Before
    public void setUp() {
        willkommenActivity = Mockito.spy(new WillkommenActivity());
        Mockito.doReturn(mockButton).when(willkommenActivity).findViewById(R.id.weiterButton);
        Mockito.doReturn(mockIntent).when(willkommenActivity).getIntent();

    }

    @Test
    public void testNameEmpty() {
        // Simuliere leeren Text im EditText
        Editable emptyEditable = new SpannableStringBuilder("");
        when(mockEditNameText.getText()).thenReturn(emptyEditable);

        // Überprüfe, ob ein Toast angezeigt wird
        verify(mockToast).show();
    }

    @Test
    public void testNameWithNumbers() {
        Mockito.when(mockEditNameText.getText()).thenReturn(Mockito.mock(CharSequence.class));
        willkommenActivity.continueOnClick();
        Mockito.verify(mockToast).show();
    }

    @Test
    public void testValidName() {
        Mockito.when(mockEditNameText.getText()).thenReturn(Mockito.mock(CharSequence.class));
        willkommenActivity.continueOnClick();
        Mockito.verify(mockIntent).putExtra(Mockito.eq("NAME_EXTRA"), Mockito.anyString());
        Mockito.verify(willkommenActivity).startActivity(mockIntent);
    }



}
