// Generated by view binder compiler. Do not edit!
package com.example.emprendimientoapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
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

public final class ActivityProductReviewBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final BottomNavigationView bottomNavigation;

  @NonNull
  public final Button buttonOk;

  @NonNull
  public final TextView productDescription;

  @NonNull
  public final ImageView productImage;

  @NonNull
  public final TextView productPrice;

  @NonNull
  public final RatingBar ratingBar;

  private ActivityProductReviewBinding(@NonNull ConstraintLayout rootView,
      @NonNull BottomNavigationView bottomNavigation, @NonNull Button buttonOk,
      @NonNull TextView productDescription, @NonNull ImageView productImage,
      @NonNull TextView productPrice, @NonNull RatingBar ratingBar) {
    this.rootView = rootView;
    this.bottomNavigation = bottomNavigation;
    this.buttonOk = buttonOk;
    this.productDescription = productDescription;
    this.productImage = productImage;
    this.productPrice = productPrice;
    this.ratingBar = ratingBar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProductReviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProductReviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_product_review, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProductReviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottom_navigation;
      BottomNavigationView bottomNavigation = ViewBindings.findChildViewById(rootView, id);
      if (bottomNavigation == null) {
        break missingId;
      }

      id = R.id.buttonOk;
      Button buttonOk = ViewBindings.findChildViewById(rootView, id);
      if (buttonOk == null) {
        break missingId;
      }

      id = R.id.product_description;
      TextView productDescription = ViewBindings.findChildViewById(rootView, id);
      if (productDescription == null) {
        break missingId;
      }

      id = R.id.product_image;
      ImageView productImage = ViewBindings.findChildViewById(rootView, id);
      if (productImage == null) {
        break missingId;
      }

      id = R.id.product_price;
      TextView productPrice = ViewBindings.findChildViewById(rootView, id);
      if (productPrice == null) {
        break missingId;
      }

      id = R.id.ratingBar;
      RatingBar ratingBar = ViewBindings.findChildViewById(rootView, id);
      if (ratingBar == null) {
        break missingId;
      }

      return new ActivityProductReviewBinding((ConstraintLayout) rootView, bottomNavigation,
          buttonOk, productDescription, productImage, productPrice, ratingBar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}