// Generated by view binder compiler. Do not edit!
package com.example.emprendimientoapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.emprendimientoapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPaymentBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText bonusCodeInput;

  @NonNull
  public final BottomNavigationView bottomNavigation;

  @NonNull
  public final ImageView cardsImage;

  @NonNull
  public final TextView confirmationTitle;

  @NonNull
  public final TextView orderAddress;

  @NonNull
  public final TextView orderQuantity;

  @NonNull
  public final TextView orderSize;

  @NonNull
  public final TextView orderTotalPrice;

  @NonNull
  public final RadioButton radioCash;

  @NonNull
  public final RadioButton radioDebitCredit;

  @NonNull
  public final RadioGroup radioGroupPaymentMethod;

  @NonNull
  public final RadioButton radioNequi;

  @NonNull
  public final TextView registeredCardsText;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final TextView shakeMessage;

  @NonNull
  public final TextView title;

  private ActivityPaymentBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText bonusCodeInput, @NonNull BottomNavigationView bottomNavigation,
      @NonNull ImageView cardsImage, @NonNull TextView confirmationTitle,
      @NonNull TextView orderAddress, @NonNull TextView orderQuantity, @NonNull TextView orderSize,
      @NonNull TextView orderTotalPrice, @NonNull RadioButton radioCash,
      @NonNull RadioButton radioDebitCredit, @NonNull RadioGroup radioGroupPaymentMethod,
      @NonNull RadioButton radioNequi, @NonNull TextView registeredCardsText,
      @NonNull ScrollView scrollView, @NonNull TextView shakeMessage, @NonNull TextView title) {
    this.rootView = rootView;
    this.bonusCodeInput = bonusCodeInput;
    this.bottomNavigation = bottomNavigation;
    this.cardsImage = cardsImage;
    this.confirmationTitle = confirmationTitle;
    this.orderAddress = orderAddress;
    this.orderQuantity = orderQuantity;
    this.orderSize = orderSize;
    this.orderTotalPrice = orderTotalPrice;
    this.radioCash = radioCash;
    this.radioDebitCredit = radioDebitCredit;
    this.radioGroupPaymentMethod = radioGroupPaymentMethod;
    this.radioNequi = radioNequi;
    this.registeredCardsText = registeredCardsText;
    this.scrollView = scrollView;
    this.shakeMessage = shakeMessage;
    this.title = title;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPaymentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPaymentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_payment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPaymentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bonusCodeInput;
      EditText bonusCodeInput = ViewBindings.findChildViewById(rootView, id);
      if (bonusCodeInput == null) {
        break missingId;
      }

      id = R.id.bottom_navigation;
      BottomNavigationView bottomNavigation = ViewBindings.findChildViewById(rootView, id);
      if (bottomNavigation == null) {
        break missingId;
      }

      id = R.id.cardsImage;
      ImageView cardsImage = ViewBindings.findChildViewById(rootView, id);
      if (cardsImage == null) {
        break missingId;
      }

      id = R.id.confirmationTitle;
      TextView confirmationTitle = ViewBindings.findChildViewById(rootView, id);
      if (confirmationTitle == null) {
        break missingId;
      }

      id = R.id.orderAddress;
      TextView orderAddress = ViewBindings.findChildViewById(rootView, id);
      if (orderAddress == null) {
        break missingId;
      }

      id = R.id.orderQuantity;
      TextView orderQuantity = ViewBindings.findChildViewById(rootView, id);
      if (orderQuantity == null) {
        break missingId;
      }

      id = R.id.orderSize;
      TextView orderSize = ViewBindings.findChildViewById(rootView, id);
      if (orderSize == null) {
        break missingId;
      }

      id = R.id.orderTotalPrice;
      TextView orderTotalPrice = ViewBindings.findChildViewById(rootView, id);
      if (orderTotalPrice == null) {
        break missingId;
      }

      id = R.id.radioCash;
      RadioButton radioCash = ViewBindings.findChildViewById(rootView, id);
      if (radioCash == null) {
        break missingId;
      }

      id = R.id.radioDebitCredit;
      RadioButton radioDebitCredit = ViewBindings.findChildViewById(rootView, id);
      if (radioDebitCredit == null) {
        break missingId;
      }

      id = R.id.radioGroupPaymentMethod;
      RadioGroup radioGroupPaymentMethod = ViewBindings.findChildViewById(rootView, id);
      if (radioGroupPaymentMethod == null) {
        break missingId;
      }

      id = R.id.radioNequi;
      RadioButton radioNequi = ViewBindings.findChildViewById(rootView, id);
      if (radioNequi == null) {
        break missingId;
      }

      id = R.id.registeredCardsText;
      TextView registeredCardsText = ViewBindings.findChildViewById(rootView, id);
      if (registeredCardsText == null) {
        break missingId;
      }

      id = R.id.scrollView;
      ScrollView scrollView = ViewBindings.findChildViewById(rootView, id);
      if (scrollView == null) {
        break missingId;
      }

      id = R.id.shakeMessage;
      TextView shakeMessage = ViewBindings.findChildViewById(rootView, id);
      if (shakeMessage == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      return new ActivityPaymentBinding((ConstraintLayout) rootView, bonusCodeInput,
          bottomNavigation, cardsImage, confirmationTitle, orderAddress, orderQuantity, orderSize,
          orderTotalPrice, radioCash, radioDebitCredit, radioGroupPaymentMethod, radioNequi,
          registeredCardsText, scrollView, shakeMessage, title);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
