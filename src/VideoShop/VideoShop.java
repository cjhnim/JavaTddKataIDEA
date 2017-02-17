package VideoShop;

/**
 * Created by francis on 2017-02-14.
 */
public class VideoShop {

    Video[] rentalVideoList = new Video[10];

    public VideoShop(Video[] list) {        // TODO: 데이터를 그냥 리스트로 주는건 웬지 무식해보임.

        if (list == null || list.length == 0) {
            rentalVideoList = new Video[0];
        } else {
            rentalVideoList = list;
        }
    }

    public VideoSearch searchUser(String userName) {

        if (rentalVideoList.length == 0) {
            return new VideoSearch();
        } else {
//            return rentalVideoList[0];
            return null;
        }
    }
}
