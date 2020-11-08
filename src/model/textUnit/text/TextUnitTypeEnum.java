package model.textUnit.text;

public enum TextUnitTypeEnum {
    // слово
    WORD {
        @Override
        public String toString() {
            return "word";
        }
    },
    // знак препинания
    PUNCTUATION_MARK {
        @Override
        public String toString() {
            return "punctuation mark";
        }
    },
    // предложение
    SENTENCE {
        @Override
        public String toString() {
            return "sentence";
        }
    },
    // строка кода
    CODE_LINE {
        @Override
        public String toString() {
            return "code line";
        }
    },
    // параграф
    PARAGRAPH {
        @Override
        public String toString() {
            return "paragraph";
        }
    },
    // блок кода
    CODE_BLOCK {
        @Override
        public String toString() {
            return "code block";
        }
    },
    // текст
    TEXT {
        @Override
        public String toString() {
            return "text";
        }
    }
}
