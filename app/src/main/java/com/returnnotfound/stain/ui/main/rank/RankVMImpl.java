package com.returnnotfound.stain.ui.main.rank;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.returnnotfound.stain.base.BaseViewModel;
import com.returnnotfound.stain.data.model.AnimeTop;
import com.returnnotfound.stain.data.repository.AnimeRepository;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RankVMImpl extends BaseViewModel implements RankVM {

  private AnimeRepository mAnimeRepo;
  private MutableLiveData<List<AnimeTop>> mAnimeTopList = new MutableLiveData<>();
  private int mCurrentPage = 1;
  private String mSubType = "upcoming";

  @Inject
  public RankVMImpl(AnimeRepository animeRepository) {
    this.mAnimeRepo = animeRepository;

    refreshAnimeList();
  }

  public LiveData<List<AnimeTop>> getmAnimeTopList() {
    return mAnimeTopList;
  }

  public void refreshAnimeList() {
    mCurrentPage = 1 + new Random().nextInt(2);
    getAnimeList(mCurrentPage, mSubType);
  }

  public void loadMoreAnimeList() {
    mCurrentPage++;
    getAnimeList(mCurrentPage, mSubType);
  }

  public void getAnimeList(int page, String subType) {
    addTask(mAnimeRepo.getAnimeTop(page, subType)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe((Consumer<List<AnimeTop>>) animeTops -> mAnimeTopList.setValue(animeTops), new Consumer<Throwable>() {
          @Override
          public void accept(Throwable throwable) throws Exception {

          }
        })
    );
  }
}
