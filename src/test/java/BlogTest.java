import blogPages.BlogPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlogTest extends BaseTest{

    BlogPage blogComment = new BlogPage();

    @Test
    public void verifyPostingAComment() {


        blogComment.navigateToBlog();
//        commercial.closeCommercialPopUp();
        blogComment.clickOnABlog();
        blogComment.postAComment("This is an interesting and fun test comment.", "Test9", "test9@test.com", "www.test.com");
        String actualCommentResult = blogComment.getName();
        String expectedCommentResult = "Your comment is awaiting moderation.";
        Assert.assertEquals(actualCommentResult, expectedCommentResult);
    }


}
