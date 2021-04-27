package com.tugas.fragmentparceable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

public class DetailActivity extends AppCompatActivity {
    ImageView ivMangaImg, ivCoverImg;
    TextView tvMangaSynopsis, tvMangaTitle, tvMangaAuthor, tvExpandableBtn;
    private MaterialToolbar materialToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        materialToolbar = findViewById(R.id.materialToolbar);

        ivMangaImg = findViewById(R.id.iv_manga_image);
        ivCoverImg = findViewById(R.id.iv_cover_img);

        tvMangaTitle = findViewById(R.id.tv_manga_title);
        tvMangaSynopsis = findViewById(R.id.tv_manga_synopsis);
        tvMangaAuthor = findViewById(R.id.tv_manga_author);
        tvExpandableBtn = findViewById(R.id.tv_expandableBtn);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MangaModel manga = getIntent().getParcelableExtra("MANGA_DETAIL");
        ivMangaImg.setBackgroundResource(manga.getImage());
        ivCoverImg.setImageResource(manga.getImage());

        tvMangaTitle.setText(manga.getTitle());
        tvMangaAuthor.setText(manga.getAuthor());
        tvMangaSynopsis.setText(manga.getSynopsis());
        tvMangaSynopsis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableTextView();
            }
        });
        tvExpandableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableTextView();
            }
        });

        materialToolbar.setTitle(manga.getTitle());
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void expandableTextView() {
        if (tvExpandableBtn.getText().toString().equalsIgnoreCase("less")){
            tvMangaSynopsis.setMaxLines(2);
            tvExpandableBtn.setText("more");
        } else {
            tvMangaSynopsis.setMaxLines(Integer.MAX_VALUE);
            tvExpandableBtn.setText("less");
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent);
    }
}