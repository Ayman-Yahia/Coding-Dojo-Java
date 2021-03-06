package com.codingdojo.DojoOverflow.models;

import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="questions")
public class Question {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionText;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private List<Answer> answers;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "questions_tags", 
            joinColumns = @JoinColumn(name = "question_id"), 
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    
    private List<Tag> tags;
    
    @Transient
	@Pattern(regexp="^(([a-zA-Z\\\\s])+$|([a-zA-Z\\\\s]+,)[a-zA-Z\\\\s]+){1,2}$",message="Tags must be separated by commas, max 3")
	private String tagName;
    
    public Question () {
    	
    }
	public Question(Long id, String questionText, List<Tag> tags) {
		this.id = id;
		this.questionText = questionText;
		this.tags = tags;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String question) {
		this.questionText = question;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String[] splitTags() {
		return this.tagName.split("\\s*,\\s*");
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public List<Answer> getAnswers() {
		
		return answers;
	}

    
}
