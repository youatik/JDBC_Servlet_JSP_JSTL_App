/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author youatik
 */
public class Produit {
    private long eanIsbn13;
    private String title;
    private String creators;
    private String firstName;
    private String lastName;
    private String description;
    private String publisher;
    private Date publishDate;
    private BigDecimal price;
    private int length;

    // Default constructor
    public Produit() {
    }
    
    //Constructor
      public Produit(long eanIsbn13, String title, String creators, String firstName, String lastName, String description, String publisher, Date publishDate, BigDecimal price, int length) {
        this.eanIsbn13 = eanIsbn13;
        this.title = title;
        this.creators = creators;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.price = price;
        this.length = length;
    }
    

    // Getters and setters for the properties
    public long getEanIsbn13() {
        return eanIsbn13;
    }

    public void setEanIsbn13(long eanIsbn13) {
        this.eanIsbn13 = eanIsbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreators() {
        return creators;
    }

    public void setCreators(String creators) {
        this.creators = creators;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
     @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        StringBuilder sb = new StringBuilder();
        sb.append("EAN/ISBN: ").append(eanIsbn13)
            .append("\nTitle: ").append(title)
            .append("\nCreators: ").append(creators)
            .append("\nFirst Name: ").append(firstName)
            .append("\nLast Name: ").append(lastName)
            .append("\nDescription: ").append(description)
            .append("\nPublisher: ").append(publisher)
            .append("\nPublish Date: ").append(dateFormat.format(publishDate))
            .append("\nPrice: ").append(price)
            .append("\nLength: ").append(length);

        return sb.toString();
    }
}

