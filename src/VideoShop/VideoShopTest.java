package VideoShop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideoShopTest {

    @Test
    public void
    고객이아무도없다_홍길동을검색해보자_빈결과가나온다() {
        VideoShop shop = new VideoShop(null);
        String userName = "홍길동";
        Video[] videoEmptyList = new Video[0];

        VideoSearch searchResult = shop.searchUser(userName);

        assertEquals(0, searchResult.rentalTotalCount(), "Video Total Count: ");
        assertEquals(0, searchResult.rentalTotalAmount(), "Rental Amount: ");
        assertEquals(0, searchResult.currentPoint(), "Current Point: ");
        assertEquals(0, searchResult.totalPoint(), "Total Point: ");
        assertArrayEquals(videoEmptyList, searchResult.videoRentalList(), "Video Rental List : ");

    }

    @Test
    public void
    가짜고객을넣고_홍길동을검색해보자_빌린비디오1개에대한정보가나온다() {

        Video[] expectVideoList = new Video[1];  // Todo: VideoBuilder를 도입하자.
        expectVideoList[0].type = Video.VideoType.MOVIE;
        expectVideoList[0].title = "타이타닉";
        expectVideoList[0].priceOfRental = 1000;

        VideoShop shop = new VideoShop(expectVideoList);
        String userName = "홍길동";

        VideoSearch searchResult = shop.searchUser(userName);

        assertEquals(1, searchResult.rentalTotalCount(), "Video Total Count: ");
        assertEquals(expectVideoList[0].priceOfRental, searchResult.rentalTotalAmount(), "Rental Amount: ");
        assertEquals(1, searchResult.currentPoint(), "Current Point: ");
        assertEquals(1, searchResult.totalPoint(), "Total Point: ");
        assertEquals(expectVideoList, searchResult.videoRentalList()[0], "Video Rental List : ");
    }
}