
import com.vmm.JHTTPServer;
import java.io.IOException;
import java.io.ObjectInputFilter.Status;
import java.util.Properties;
import java.sql.ResultSet;
import jdbcexp.DBLoader;

public class MYWebServerClass extends JHTTPServer {

    public MYWebServerClass(int port) throws IOException {
        super(port);
    }

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) {
        Response res = new Response(HTTP_OK, "text/plain", "Server is ready.");
        System.out.println("uri-->" + uri);
        if (uri.contains("usersignupframe")) {
            String username = parms.getProperty("username");
            //keynames
            String password = parms.getProperty("password");
            String email = parms.getProperty("email");
            String phoneno = parms.getProperty("phone no");
            String gender = parms.getProperty("gender");
            //String photo = parms.getProperty("photo");

            // String ans = "username" + username + "email" + email + "phoneno" + phoneno + "gender" + gender;
            //res = new Response(HTTP_OK, "text/plain", ans);
            try {

                ResultSet rs = DBLoader.executeQuery("Select * from user where username='" + username + "'");

                if (rs.next()) {
                    res = new Response(HTTP_OK, "text/plain", "FAILS");
                } else {
                    String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/uploads");
                    String photoname = "src/uploads/" + filename;
                    rs.moveToInsertRow();
                    rs.updateString("username", username);
                    rs.updateString("password", password);
                    rs.updateString("email", email);
                    rs.updateString("phone", phoneno);
                    rs.updateString("gender", gender);
                    rs.updateString("photo", photoname);
                    rs.insertRow();
                    res = new Response(HTTP_OK, "text/plain", "SUCCESS");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("userlogin")) {
            //get username and password
            //DBLoader sql select * from users where  username =  username and password = password
            String username = parms.getProperty("username");
            String password = parms.getProperty("Password");
            try {
                ResultSet rs = DBLoader.executeQuery("select * from user where username='" + username + "' and password='" + password + "'");
                if (rs.next()) {
                    //login successfull
                    res = new Response(HTTP_OK, "text/plain", "SUCCESS");

                } else {
                    res = new Response(HTTP_OK, "text/plain", "FAILS");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("userchangepassword")) {
            //get all data
            String username = parms.getProperty("username");
            String oldPassword = parms.getProperty("oldPassword");
            String newPassword = parms.getProperty("newPassword");
            //DBLoader
            try {
                ResultSet rs = DBLoader.executeQuery("select * from user where username='" + username + "' and password='" + oldPassword + "'");
                if (rs.next()) {
                    //login successfull
                    rs.updateString("password", newPassword);
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "SUCCESS");

                } else {
                    res = new Response(HTTP_OK, "text/plain", "FAILS");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("getdata")) {
            //get all data
            String username = parms.getProperty("username");
            String ans = "";
            try {

                ResultSet rs = DBLoader.executeQuery("select * from user where username='" + username + "'");
                if (rs.next()) {
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String photo = rs.getString("photo");
                    ans += email + ";;" + phone + ";;" + photo;
                    res = new Response(HTTP_OK, "text/plain", ans);
                } else {
                    res = new Response(HTTP_OK, "text/plain", "FAILS");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("usereditwithoutphoto")) {
            String username = parms.getProperty("username");
            String email = parms.getProperty("email");
            String phoneno = parms.getProperty("phoneno");
            try {
                ResultSet rs = DBLoader.executeQuery("select * from user where username='" + username + "' ");

                if (rs.next()) {
                    rs.updateString("email", email);
                    rs.updateString("phone", phoneno);
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "SUCCESS");

                } else {
                    res = new Response(HTTP_OK, "text/plain", "FAILS");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("usereditwithphoto")) {
            String username = parms.getProperty("username");
            String email = parms.getProperty("email");
            String phoneno = parms.getProperty("phoneno");
            String photo = parms.getProperty("photo");
            try {
                ResultSet rs = DBLoader.executeQuery("select * from user where username='" + username + "' ");

                if (rs.next()) {
                    String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/uploads");
                    String photoname = "src/uploads/" + filename;
                    rs.updateString("email", email);
                    rs.updateString("phone", phoneno);
                    rs.updateString("photo", photoname);
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "SUCCESS");

                } else {
                    res = new Response(HTTP_OK, "text/plain", "FAILS");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("usersearch")) {
            //get data
            String username = parms.getProperty("username");
            String keyword = parms.getProperty("keyword");

            try {
                ResultSet rs = DBLoader.executeQuery("select * from user where username like'" + keyword + "%' and username!='" + username + "'");
                String ans = "";
                String Status = "";
                String ifFollow = "no";

                while (rs.next()) {
                    String user = rs.getString("username");
                    String photo = rs.getString("photo");
                    String email = rs.getString("email");

                    ResultSet rs2 = DBLoader.executeQuery("select * from followuser where followby ='" + username + "'and followto='" + user + "'");
                    if (rs2.next()) {
                        ifFollow = "yes";

                    }
                    //String phone = rs.getString("phone");
                    ans += user + ";;" + photo + ";;" + email + ";;" + ifFollow + "~~";
                }
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }//logic to follow unfollow other user
        else if (uri.equals("/userfollow")) {
            String followto = parms.getProperty("followto");
            String followby = parms.getProperty("followby");

            try {
                ResultSet rs = DBLoader.executeQuery("select * from followuser where followby ='" + followby + "'and followto='" + followto + "'");
                if (rs.next()) {
                    rs.deleteRow();

                    res = new Response(HTTP_OK, "text/plain", "FAILS");
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("followby", followby);
                    rs.updateString("followto", followto);
                    rs.insertRow();

                    res = new Response(HTTP_OK, "text/plain", "SUCCESS");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } //loged in user ke followers fetch larne ke liye
        else if (uri.equals("/userfollowers")) {
            String username = parms.getProperty("username");
            //System.out.println(followby + " " + followto);
            try {
                String ans = "";
                ResultSet rs = DBLoader.executeQuery("select * from followuser where followto ='" + username + "'");
                while (rs.next()) {

                    String user = rs.getString("followby");
                    String followerid = rs.getString("followerid");

                    ResultSet rs1 = DBLoader.executeQuery("select * from user where username like'" + user + "'");
                    if (rs1.next()) {
                        String username1 = rs1.getString("username");
                        String photo = rs1.getString("photo");
                        String email = rs1.getString("email");

                        ans += username1 + ";;" + photo + ";;" + email + ";;" + followerid + "~~";

                    }
                    res = new Response(HTTP_OK, "text/plain", ans);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("removefollowers")) {
            String followerid = parms.getProperty("followerid");
            try {
                ResultSet rs = DBLoader.executeQuery(" select * from followuser where followerid ='" + followerid + "'");
                if (rs.next()) {
                    rs.deleteRow();
                    res = new Response(HTTP_OK, "text/plain", "SUCCESS");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "FAILS");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.equals("/userfollowing")) {
            String username = parms.getProperty("username");
            //System.out.println(followby + " " + followto);
            try {
                String ans = "";
                ResultSet rs = DBLoader.executeQuery("select * from followuser where followby ='" + username + "'");
                while (rs.next()) {

                    String user = rs.getString("followto");
                    String followerid = rs.getString("followerid");
                    ResultSet rs1 = DBLoader.executeQuery("select * from user where username like'" + user + "'");
                    if (rs1.next()) {
                        String username1 = rs1.getString("username");
                        String photo = rs1.getString("photo");
                        String email = rs1.getString("email");

                        ans += username1 + ";;" + photo + ";;" + email + ";;" + followerid + "~~";

                    }
                    res = new Response(HTTP_OK, "text/plain", ans);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("removefollowing")) {
            String followerid = parms.getProperty("followerid");
            try {
                ResultSet rs = DBLoader.executeQuery(" select * from followuser where followerid ='" + followerid + "'");
                if (rs.next()) {
                    rs.deleteRow();
                    res = new Response(HTTP_OK, "text/plain", "SUCCESS");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "FAILS");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.equals("")) {
            //get caption photo username
            //Dbloader select * from posts 
            //insert row 
        } else if (uri.equals("/userforgotpassword")) {
            String username = parms.getProperty("username");
            try {
                String ans = "";
                ResultSet rs = DBLoader.executeQuery("select * from user where username ='" + username + "'");

                if (rs.next()) {
                    int random = (int) (1000 + (9999 - 1000) * Math.random());
                    String otp = random + "";
                    res = new Response(HTTP_OK, "text/plain", otp);
                } else {
                    res = new Response(HTTP_OK, "text/plain", "FAILS");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.equals("/usersetpassword")) {
            String username = parms.getProperty("username");
            String newpassword = parms.getProperty("newpassword");
            try {

                ResultSet rs = DBLoader.executeQuery("select * from user where username ='" + username + "'");
                if (rs.next()) {
                    rs.updateString("password", newpassword);
                    rs.updateRow();
                    res = new Response(HTTP_OK, "text/plain", "UPDATED");
                } else {
                    res = new Response(HTTP_OK, "text/plain", "FAILS");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.equals("/getallpost")) {
            String username = parms.getProperty("username");
            try {
                ResultSet rs = DBLoader.executeQuery("select * from post where username='" + username + "'");

                String ans = "";
                while (rs.next()) {
                    String caption = rs.getString("caption");
                    String photo = rs.getString("photo");
                    String postid = rs.getString("postid");
                    String date_time = rs.getString("date_time");

                    ans += caption + ";;" + photo + ";;" + postid + ";;" + date_time + "~~";

                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.equals("/useraddpost")) {
            String username = parms.getProperty("username");
            System.out.println("username is----->" + username);
            // String photo = parms.getProperty("photo");
            String caption = parms.getProperty("caption");
            System.out.println("-" + username);
            try {
                ResultSet rs = DBLoader.executeQuery("select * from post");
                String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/uploads");
                rs.moveToInsertRow();
                rs.updateString("username", username);
                rs.updateString("caption", caption);
                rs.updateString("photo", "src/uploads/" + filename);
                rs.insertRow();
                res = new Response(HTTP_OK, "text/plain", "SUCCESS");

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("useraddstory")) {
            try {
                String caption = parms.getProperty("caption");
                String postid = parms.getProperty("postid");
                ResultSet rs = DBLoader.executeQuery("Select * from story");

                String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/uploads");
                String photoname = "src/uploads/" + filename;

                rs.moveToInsertRow();

                rs.updateString("caption", caption);
                rs.updateString("postid", postid);
                rs.updateString("photo", photoname);

                rs.insertRow();
                res = new Response(HTTP_OK, "text/plain", "SUCCESS");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("getallstories")) {

            String postid = parms.getProperty("postid");
            System.out.println("-" + postid);
            try {
                ResultSet rs = DBLoader.executeQuery("Select * from story where postid='" + postid + "'");
                String ans = "";
                while (rs.next()) {
                    String caption = rs.getString("caption");
                    String photo = rs.getString("photo");
                    int storyid = rs.getInt("storyid");

                    ans += caption + "!!" + photo + "!!" + storyid + "~~";
                }

                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.contains("/GetResource")) {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            res = sendCompleteFile(uri);
            System.out.println("Response reference to be send to client-------------" + res);
        } else if (uri.contains("/fetchfollowingpost")) {
            String username = parms.getProperty("username");
            try {
                ResultSet rs = DBLoader.executeQuery("select * from followuser where followby='" + username + "'");
                String ans = "";

                while (rs.next()) {
                    String followto = rs.getString("followto");
                    ResultSet rs2 = DBLoader.executeQuery("select * from post where username='" + followto + "'");
                    while (rs2.next()) {
                        int postid = rs2.getInt("postid");
                        String date_time = rs2.getString("date_time");
                        String title = rs2.getString("caption");
                        String photo = rs2.getString("photo");
                        String is_like = "";
                        int count_like = 0;
                        ResultSet rs3 = DBLoader.executeQuery("select * from like_post where postid='" + postid + "' and username='" + username + "'");
                        if (rs3.next()) {
                            is_like = "yes";
                        } else {
                            is_like = "no";
                        }
                        ResultSet rs4 = DBLoader.executeQuery("select count(*) from like_post where postid=" + postid);
                        if (rs4.next()) {
                            count_like = rs4.getInt("count(*)");
                        }
                        String row = followto + ";;" + postid + ";;" + date_time + ";;" + title + ";;" + photo + ";;" + is_like + ";;" + count_like;
                        ans = ans + row + "~~";
                    }
                }
                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/likepost")) {
            String postid = parms.getProperty("postid");
            String username = parms.getProperty("username");
            try {
                ResultSet rs = DBLoader.executeQuery("select * from like_post where postid= " + postid + " and username='" + username + "'");
                String ans = "";
                if (rs.next()) {
                    rs.deleteRow();
                    ans = "unlike";
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("username", username);
                    rs.updateString("postid", postid);
                    rs.insertRow();
                    ans = "like";
                }

                res = new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return res;

    }

    
}
