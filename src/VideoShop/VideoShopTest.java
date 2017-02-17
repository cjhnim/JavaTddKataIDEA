package VideoShop;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


class VideoShopTest {

    @Test
    public void
    고객이아무도없다_홍길동을검색해보자_빈결과가나온다() {
        VideoShop shop = new VideoShop();
        String userName = "홍길동";
        Video[] videoEmptyList = new Video[0];

        RentalReport searchResult = shop.searchUser(userName);

        assertEquals(0, searchResult.rentalTotalCount(), "Video Total Count: ");
        assertArrayEquals(videoEmptyList, searchResult.videoRentalList(), "Video Rental List : ");
        assertEquals(0, searchResult.rentalTotalAmount(), "Rental Amount: ");
        assertEquals(0, searchResult.currentPoint(), "Current Point: ");
        assertEquals(0, searchResult.totalPoint(), "Total Point: ");
    }
}