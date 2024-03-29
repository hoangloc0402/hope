package com.sunset.hope.helpers;
import com.sunset.hope.entities.Comment;
import com.sunset.hope.entities.Contact;
import com.sunset.hope.entities.Post;
import com.sunset.hope.entities.User;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PostDataRandomizer {

    private String[] postId = {"1","2","3","4","5","6","7","8","9","0"};
    private String[] type = {"Bloods", "Clothes", "Foods", "Medicines", "Money"};
    private String[] postTags = {"Donation", "Request"};
    private int[] images = null;
    private String[] description = {
            "For the public benefit, the relief and assistance of people in need (what) in any part of the world (where) who are the victims of war or natural disaster or catastrophe (who) by supplying them with medical aid (how).",
            "The relief of unemployment for the public benefit in [x place], including assistance to find employment",
            "Charity officers or administrators work for charitable organisations. Some of their duties are related to business development, project management, public relations, strategy, marketing, finance, etc. These officers have different tasks depending on the size of the charitable organization, for instance, in smaller charities they are responsible for advise and information tasks for volunteers.",
            "There are job openings in most UK cities for interested candidates. Work hours often fall in the evening or at the weekend as this is the best time to approach potential donors. Posts are usually hourly paid with rates from national minimum wage up to £8.00 per hour. Some employers provide bonus schemes based on donations raised.",
            "Positions for charity telephone fundraisers, street and door-to-door fundraisers require job incumbents to draw the attention of members of the public to specific causes and entice them into making one-off or ongoing donations, without leaving them with a disgruntled feeling. ",
            "Fundraisers for charity provide a vital link between the general public and needy causes both at home and abroad. People who have taken on the role are respected for their sunny natures and their dedication to furthering the lot of less fortunate individuals. ",
            "You must know how to create and use AlertDialog basically. This article will show you two advanced examples about how to add custom list items and custom view objects in android Alert Dialog.",
            "ALSAC (American Lebanese Syrian Associated Charities) was founded in 1957 and exists for the sole purpose of raising funds to support the operating and maintenance of St. Jude Children's Research Hospital. The mission of St. Jude Children's Research Hospital is to find cures for children with cancer and other catastrophic diseases through research and treatment. ",
            "The mission of Wounded Warrior Project is to honor and empower wounded warriors. Our purpose is: to raise awareness and enlist the public's aid for the needs of severely injured service men and women; to help severely injured service members aid and assist each other; and to provide unique, direct programs and services to meet the needs of severely injured service members.",
            "Charity Navigator is collaborating with GuideStar, GlobalGiving, Classy, and ImpactMatters to display impact-related information for rated nonprofits. However, not all rated nonprofits have provided impact information yet."};
    private boolean[] isClosed = {true, false};
    private String[] time = {"24-02-2019 10:10:10","22-02-2019 10:10:12","23-02-2019 14:12:09",
            "24-02-2019 18:10:00","21-02-2019 09:18:32", "21-02-2019 05:01:32", "16-02-2019 05:01:32",
            "19-02-2019 07:01:32", "22-02-2019 21:01:32", "24-02-2019 12:01:32", "18-02-2019 05:01:32",
            "20-02-2019 08:01:32"};
    private String[] title = {
            "Need Food Donation ",
            "Offer Blood of Type A",
            "Need more cloths for children",
            "Money Donation",
            "Donate 1000$ for young patients",
            "Fundraisers for charity",
            "Charity Comminication",
            "Offer Blood of Type AB"
    };
    private String[] phone = {
            "0123456789", "452365891","12452358","558865455","751226589","452621588","46623594","741852963"
    };
    private String[] address = {
            "123 Li Thuong Kiet ",
            "456 Ton Duc Thang",
            "489 Lu Gia",
            "Quan 2 TPHCM",
            "Quan Thu Duc",
            "Quan 1 TPHCM",
    };
    private String[] mail = {
            "hoangloc@gmail.com",
            "haohihi@gmail.com",
            "tuongwall@gmail.com",
            "thanh@hotmail.com",
            "tiennguyen@gmail.com",
            "khasan@gmail.com",
            "khanghihi@gmail.com",
            "vanhung@gmail.com"
    };

    private User[] user = {
            new User("hoangloc","Nguyen Hoang Loc",
                    new Contact(phone[getNum(phone.length)], address[getNum(address.length)], mail[getNum(mail.length)]), true, ""),
            new User("minhhao","Van Minh Hao",
                    new Contact(phone[getNum(phone.length)], address[getNum(address.length)], mail[getNum(mail.length)]), false, ""),
            new User("vantuong","Nguyen Van Tuong",
                    new Contact(phone[getNum(phone.length)], address[getNum(address.length)], mail[getNum(mail.length)]), false, ""),
            new User("vanthanh","Nguyen Van Thanh",
                    new Contact(phone[getNum(phone.length)], address[getNum(address.length)], mail[getNum(mail.length)]), false, ""),
            new User("anhtien","Nguyen Huu Anh Tien",
                    new Contact(phone[getNum(phone.length)], address[getNum(address.length)], mail[getNum(mail.length)]), false, ""),
            new User("bvq1","Central Hospital",
                    new Contact(phone[getNum(phone.length)], address[getNum(address.length)], mail[getNum(mail.length)]), true, ""),
            new User("bvq2","Cho Ray Hospital",
                    new Contact(phone[getNum(phone.length)], address[getNum(address.length)], mail[getNum(mail.length)]), true, ""),
            new User("bvq3","115 Hospital",
                    new Contact(phone[getNum(phone.length)], address[getNum(address.length)], mail[getNum(mail.length)]), true, ""),
            new User("bvq4","Thong Nhat Hospital",
                    new Contact(phone[getNum(phone.length)], address[getNum(address.length)], mail[getNum(mail.length)]), true, ""),
            new User("bvq5","Chan Thuong Chinh Hinh Hospital",
                    new Contact(phone[getNum(phone.length)], address[getNum(address.length)], mail[getNum(mail.length)]), true, "")
    };

    public User[] getUser() {
        return user;
    }

    ArrayList<Comment> commentList;



    public static Integer getNum(int max){
        Random rand = new Random();
        return rand.nextInt(max);
    }

    public Post getPost(){
        commentList = new ArrayList<>();
        String postID = postId[getNum(postId.length)];
//        int max = getNum(59);
        int max = 59;
        commentList.add(new Comment(postID, "1", "Great", user[getNum(user.length)].getUserName(), String.valueOf(max) +" minutes"));
//        max = getNum(max);
        commentList.add(new Comment(postID, "2", "Thank God you are here", user[getNum(user.length)].getUserName(), String.valueOf(max-4) +" minutes"));
//        max = getNum(max);
        commentList.add(new Comment(postID, "3", "God Bless You!", user[getNum(user.length)].getUserName(), String.valueOf(max-6) +" minutes"));
//        max = getNum(max);
        commentList.add(new Comment(postID, "4", "Thank you!", user[getNum(user.length)].getUserName(), String.valueOf(max-10) +" minutes"));
//        max = getNum(max);
        commentList.add(new Comment(postID, "5", "You have made our world better!", user[getNum(user.length)].getUserName(), String.valueOf(max-18) +" minutes"));
//        max = getNum(max);
        commentList.add(new Comment(postID, "6", "Call 0969241342!", user[getNum(user.length)].getUserName(), String.valueOf(max-50) +" minutes"));
//        commentList.add(new Comment(postID, "4", "Thank you!", user[getNum(user.length)].getUserName(), "50 minutes"));
        return new Post(
            postID,
            user[getNum(user.length)],
            type[getNum(type.length)],
            postTags[getNum(postTags.length)],
            null,
            description[getNum(description.length)],
            isClosed[getNum(isClosed.length)],
            time[getNum(time.length)],
            title[getNum(title.length)],
            new Contact(phone[getNum(phone.length)], address[getNum(address.length)], mail[getNum(mail.length)]),
            commentList
        );
    }
}
