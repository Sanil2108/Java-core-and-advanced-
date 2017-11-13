import java.io.*;
import java.util.NoSuchElementException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;


public class javaStax1{
    final static String DEFAULT_VALUE="N/A";
    final static boolean DEBUG=false;

    public static Discussion[] readAllDiscussion(){
        Discussion[] allDiscussions=null;
        int discussionIndex=0;

        try{
            XMLInputFactory xmlInputFactory=XMLInputFactory.newInstance();
            XMLEventReader eventReader=xmlInputFactory.createXMLEventReader(
                new FileReader("javaStax1.xml")
            );
            XMLEvent currentEvent=eventReader.nextEvent();
            int count=-1;

            //read count
            while(!(currentEvent.isStartElement() && 
                currentEvent.asStartElement().getName().toString().equals(Discussion.COUNT))){
                currentEvent=eventReader.nextEvent();
            }
            currentEvent=eventReader.nextEvent();
            if(currentEvent.isCharacters()){
                count=Integer.parseInt(currentEvent.asCharacters().getData());
            }
            allDiscussions=new Discussion[count];
            if(DEBUG){
                System.out.println("Count - "+count);
            }

            //read all discussions
            while(eventReader.hasNext()){
                currentEvent=eventReader.nextEvent();
                if(currentEvent.isStartElement() && 
                    currentEvent.asStartElement().getName().toString().equals(Discussion.ROOT)){
                    //Read the discussion
                    String title=DEFAULT_VALUE;
                    String user=DEFAULT_VALUE;
                    String contents=DEFAULT_VALUE;
                    
                    //Read the username
                    while(!(currentEvent.isStartElement() &&
                        currentEvent.asStartElement().getName().toString().equals(Discussion.USER))){
                        currentEvent=eventReader.nextEvent();
                    }
                    currentEvent=eventReader.nextEvent();
                    if(currentEvent.isCharacters()){
                        user=currentEvent.asCharacters().getData();
                    }
                    if(DEBUG){
                        System.out.println("user - "+user);
                    }

                    // read the title
                    while(!(currentEvent.isStartElement() &&
                        currentEvent.asStartElement().getName().toString().equals(Discussion.TITLE))){
                        currentEvent=eventReader.nextEvent();
                    }
                    currentEvent=eventReader.nextEvent();
                    if(currentEvent.isCharacters()){
                        title=currentEvent.asCharacters().getData();
                    }
                    if(DEBUG){
                        System.out.println("title - "+title);
                    }
                    
                    // read the contents
                    while(!(currentEvent.isStartElement() &&
                        currentEvent.asStartElement().getName().toString().equals(Discussion.CONTENTS))){
                        currentEvent=eventReader.nextEvent();
                    }
                    currentEvent=eventReader.nextEvent();
                    if(currentEvent.isCharacters()){
                        contents=currentEvent.asCharacters().getData();
                    }
                    if(DEBUG){
                        System.out.println("contents - "+contents);
                    }

                    //Get to comments
                    while(!(currentEvent.isStartElement() &&
                        currentEvent.asStartElement().getName().toString().equals(Discussion.COMMENTS))){
                        currentEvent=eventReader.nextEvent();
                    }
                    currentEvent=eventReader.nextEvent();
                    
                    //Get the count
                    int commentCount=0;
                    while(!(currentEvent.isStartElement() &&
                        currentEvent.asStartElement().getName().toString().equals(Comment.COUNT))){
                        currentEvent=eventReader.nextEvent();
                    }
                    currentEvent=eventReader.nextEvent();
                    if(currentEvent.isCharacters()){
                        commentCount=Integer.parseInt(currentEvent.asCharacters().getData());
                    }
                    Comment[] comments=new Comment[commentCount];
                    if(DEBUG){
                        System.out.println("comment count - "+commentCount);
                    }

                    //Iterate trhough all the comments
                    int i=0;
                    while(i<commentCount){

                        Comment c;
                        String commentText=DEFAULT_VALUE;
                        String commentUser=DEFAULT_VALUE;

                        currentEvent=eventReader.nextEvent();
                    
                        while(!(currentEvent.isStartElement() && 
                            currentEvent.asStartElement().getName().toString().equals(Comment.TEXT))){
                            currentEvent=eventReader.nextEvent();
                        }
                        if(currentEvent.isCharacters()){
                            commentText=currentEvent.asCharacters().getData();
                        }
                        if(DEBUG){
                            System.out.println("comment text - "+commentText);
                        }

                        while(!(currentEvent.isStartElement() && 
                            currentEvent.asStartElement().getName().toString().equals(Comment.USER))){
                            currentEvent=eventReader.nextEvent();
                        }
                        if(currentEvent.isCharacters()){
                            commentUser=currentEvent.asCharacters().getData();
                        }
                        if(DEBUG){
                            System.out.println("comment user - "+commentUser);
                        }

                        c=new Comment(commentText, commentUser);
                        comments[i]=c;

                        i++;
                        currentEvent=eventReader.nextEvent();
                    }

                    Discussion discussion=new Discussion(title, user, contents, comments);
                    allDiscussions[discussionIndex++]=discussion;

                    System.out.println("Discussion read - "+discussion);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return allDiscussions;
    }
    
    public static void main(String[] args){
        readAllDiscussion();
    }

    static class Discussion{
        final static String COUNT="count";
        final static String ROOT="discussion";
        final static String TITLE="title";
        final static String USER="user";
        final static String CONTENTS="contents";
        final static String COMMENTS="comments";

        String title;
        String user;
        String contents;
        Comment[] comments;

        public Discussion(String title, String user, String contents, Comment[] comments){
            this.title=title;
            this.user=user;
            this.contents=contents;
            this.comments=comments;
        }

        @Override
        public String toString(){
            return "Discussion[title="+title+", user="+user+", contents="+contents+", comments="+comments+"]";
        }
    }

    static class Comment{
        final static String COUNT="count";
        final static String TEXT="text";
        final static String USER="user";

        String text;
        String user;
        
        public Comment(String text, String user){
            this.text=text;
            this.user=user;
        }

        @Override
        public String toString(){
            return "Comment[text="+text+", user="+user+"]";
        }
    }

}