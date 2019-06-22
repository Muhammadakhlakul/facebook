import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public class PostsFromPageExtractor {

/**
 * A simple Facebook4J client which
 * illustrates how to access group feeds / posts / comments.
 * 
 * @param args
 * @throws FacebookException 
 */
public static void main(String[] args) throws FacebookException {

    // Generate facebook instance.
    Facebook facebook = new FacebookFactory().getInstance();
    // Use default values for oauth app id.
    facebook.setOAuthAppId("559244357936625", "cae51293c0116bae37a5ea5f61335e36");
    // Get an access token from: 
    // https://developers.facebook.com/tools/explorer
    // Copy and paste it below.
    String accessTokenString = "EAAH8oTlMJfEBAEkPI9H81XfObjTBEnQb4nhPRIhjlWorCfqcouaPHxYYPAYjcaPz1c3OAUfiFZB1Q6Nkzf39en1s15CYhaEMaRWvRkDIsaWmiEm9LqWnmEoTajJVaZALBri1SNjszBMFFuIZBTKEUtS8ZAEdrR2BDaXNpfXUiP1xYPN0J3zjIZBebcNcseytcsxMuu8dzlgZDZD";
    AccessToken at = new AccessToken(accessTokenString);
    // Set access token.
    facebook.setOAuthAccessToken(at);

    // We're done.
    // Access group feeds.
    // You can get the group ID from:
    // https://developers.facebook.com/tools/explorer

    // Set limit to 25 feeds.
    ResponseList<Post> feeds = facebook.getFeed("2287117331348528",
            new Reading().limit(25));
            //System.out.println(feeds);

        // For all 25 feeds...
        for (int i = 0; i < feeds.size(); i++) {
            // Get post.
            Post post = feeds.get(i);
            
            // Get (string) message.
            String message = post.getMessage();
                            // Print out the message.
            System.out.println(message);

            // Get more stuff...
            PagableList<Comment> comments = post.getComments();
            //String date = post.getCreatedTime().toString();
            //String name = post.getFrom().getName();
            String id = post.getId();
        }           
    }
}