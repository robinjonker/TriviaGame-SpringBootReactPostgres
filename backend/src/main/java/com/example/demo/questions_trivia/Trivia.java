package com.example.demo.questions_trivia;

import com.example.demo.options_trivia.Options;

import javax.persistence.*;

@Entity
@Table
public class Trivia {
    @Id
    @SequenceGenerator(
            name = "trivia_sequence",
            sequenceName = "trivia_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trivia_sequence"
    )
    private Long id;
    private String category;
    private String topic;
    private String question;
    private String answer;

    // trivia options of possible answers
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_options_id", referencedColumnName = "id")
    private Options options;

    public Trivia() {
    }

    public Trivia(Long id,
                  String category,
                  String topic,
                  String question,
                  Options options,
                  String answer) {
        this.id = id;
        this.category = category;
        this.topic = topic;
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public Trivia(String category,
                  String topic,
                  String question,
                  Options options,
                  String answer) {
        this.category = category;
        this.topic = topic;
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Trivia{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", topic='" + topic + '\'' +
                ", question='" + question + '\'' +
                ", options=" + options +
                ", answer='" + answer + '\'' +
                '}';
    }
}
