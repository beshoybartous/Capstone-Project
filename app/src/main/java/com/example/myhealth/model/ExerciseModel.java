package com.example.myhealth.model;

import java.util.List;

public class ExerciseModel {

    private List<ExercisesBean> exercises;

    public List<ExercisesBean> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExercisesBean> exercises) {
        this.exercises = exercises;
    }

    public static class ExercisesBean {
        /**
         * muscles : {"target":"Deltoid, Anterior"}
         * name : Barbell Behind Neck Press
         * classification : {"mechanics":"Compound","force":"Push","utility":"Basic"}
         * comments : Exercise may be performed on shoulder press apparatus with rack or off of power rack with seat or without back support. Also see mount and dismount off of special articulating rack.
         * gif : https://exrx.net/application/files/8614/3938/5124/BBSeatedBehindNeckPress.gif
         * instructions : {"preparation":"Grasp barbell with overhand grip from rack or clean from floor. Position bar behind neck.","execution":"Press bar upward until arms are extended overhead. Return behind neck and repeat."}
         */

        private MusclesBean muscles;
        private String name;
        private ClassificationBean classification;
        private String comments;
        private String gif;
        private InstructionsBean instructions;

        public MusclesBean getMuscles() {
            return muscles;
        }

        public void setMuscles(MusclesBean muscles) {
            this.muscles = muscles;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ClassificationBean getClassification() {
            return classification;
        }

        public void setClassification(ClassificationBean classification) {
            this.classification = classification;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public String getGif() {
            return gif;
        }

        public void setGif(String gif) {
            this.gif = gif;
        }

        public InstructionsBean getInstructions() {
            return instructions;
        }

        public void setInstructions(InstructionsBean instructions) {
            this.instructions = instructions;
        }

        public static class MusclesBean {
            /**
             * target : Deltoid, Anterior
             */

            private String target;

            public String getTarget() {
                return target;
            }

            public void setTarget(String target) {
                this.target = target;
            }
        }

        public static class ClassificationBean {
            /**
             * mechanics : Compound
             * force : Push
             * utility : Basic
             */

            private String mechanics;
            private String force;
            private String utility;

            public String getMechanics() {
                return mechanics;
            }

            public void setMechanics(String mechanics) {
                this.mechanics = mechanics;
            }

            public String getForce() {
                return force;
            }

            public void setForce(String force) {
                this.force = force;
            }

            public String getUtility() {
                return utility;
            }

            public void setUtility(String utility) {
                this.utility = utility;
            }
        }

        public static class InstructionsBean {
            /**
             * preparation : Grasp barbell with overhand grip from rack or clean from floor. Position bar behind neck.
             * execution : Press bar upward until arms are extended overhead. Return behind neck and repeat.
             */

            private String preparation;
            private String execution;

            public String getPreparation() {
                return preparation;
            }

            public void setPreparation(String preparation) {
                this.preparation = preparation;
            }

            public String getExecution() {
                return execution;
            }

            public void setExecution(String execution) {
                this.execution = execution;
            }
        }
    }
}
