package models.brownPeterson;

import javax.persistence.*;
import play.db.ebean.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table (name="brown_peterson_quiz")
public class Quiz extends Model{
	@Id
	public long id;
	@Column(length=3)
	public int initCountdown = 100;
	@Column(length=20)
	public int flashTime =5;

	@ManyToOne
	public Trial trial;

	@ManyToOne
	public Question question;

	@OneToMany
	public List<Answer> answers = new ArrayList<Answer>();

	public Quiz(int initCountdown, int flashTime){
		this.initCountdown = initCountdown;
		this.flashTime = flashTime;
	}

	public static Quiz create(int initCountdown, int flashTime, Trial trial, Question question){
		Quiz quiz = new Quiz(initCountdown, flashTime);
		quiz.trial = trial;
		quiz.question = question;
		return quiz;
	}

	public static List<Quiz> findInvolving(Trial trial){
		return find.where().eq("trial", trial).findList();
	}
	
	@SuppressWarnings("unchecked")
	public static Finder<Long, Quiz> find = new Finder(Long.class, Quiz.class);
}