def check_response():
    while True:
        response = input().strip().upper()
        if response in ['A', 'B']:
            return response
        else:
            print("Invalid input. Please enter 'A' or 'B'.")


def print_extrovert_introvert(user_responses, questions):
    e_count = 0
    i_count = 0

    for index in range(0, len(questions), 4):
        selected_option = questions[index][0] if user_responses[index] == 'A' else questions[index][1]
        print(f"Q{index + 1}: {selected_option}")

        if user_responses[index] == 'A':
            e_count += 1
        else:
            i_count += 1

    print(f"Number of A selected: {e_count}")
    print(f"Number of B selected: {i_count}\n")


def print_sensing_intuition(user_responses, questions):
    s_count, n_count = 0, 0
    for index in range(1, len(questions), 4):
        selected_option = questions[index][0] if user_responses[index] == 'A' else questions[index][1]
        print(f"Q{index + 1}: {selected_option}")

        if user_responses[index] == 'A':
            s_count += 1
        else:
            n_count += 1

    print(f"Number of A selected: {s_count}")
    print(f"Number of B selected: {n_count}\n")


def print_thinking_feeling(user_responses, questions):
    t_count, f_count = 0, 0
    for index in range(2, len(questions), 4):
        selected_option = questions[index][0] if user_responses[index] == 'A' else questions[index][1]
        print(f"Q{index + 1}: {selected_option}")

        if user_responses[index] == 'A':
            t_count += 1
        else:
            f_count += 1

    print(f"Number of A selected: {t_count}")
    print(f"Number of B selected: {f_count}\n")


def print_judging_perceptive(user_responses, questions):
    j_count, p_count = 0, 0
    for index in range(3, len(questions), 4):
        selected_option = questions[index][0] if user_responses[index] == 'A' else questions[index][1]
        print(f"Q{index + 1}: {selected_option}")

        if user_responses[index] == 'A':
            j_count += 1
        else:
            p_count += 1

    print(f"Number of A selected: {j_count}")
    print(f"Number of B selected: {p_count}\n")

def get_MBTI_description(mbti):
    match mbti: 
        case "INTJ": 
            return ("INTJ (Architect) is a personality type with the Introverted, Intuitive, Thinking, and Judging traits. These thoughtful tacticians love perfecting the details of life, applying creativity and rationality to everything they do. Their inner world is often a private, complex one.")

        case "INFJ":
            return ("INFJ (Advocate) is a personality type with the Introverted, Intuitive, Feeling, and Judging traits. They tend to approach life with deep thoughtfulness and imagination. Their inner vision, personal values, and a quiet, principled version of humanism guide them in all things.")

        case "ISTJ":
            return ("ISTJ (Logistician) is a personality type with the Introverted, Observant, Thinking, and Judging traits. These people tend to be reserved yet willful, with a rational outlook on life. They compose their actions carefully and carry them out with methodical purpose.")

        case "ISTP":
            return ("ISTP (Virtuoso) is a personality type with the Introverted, Observant, Thinking, and Prospecting traits. They tend to have an individualistic mindset, pursuing goals without needing much external connection. They engage in life with inquisitiveness and personal skill, varying their approach as needed.")

        case "INTP":
            return ("INTP (Logician) is a personality type with the Introverted, Intuitive, Thinking, and Prospecting traits. These flexible thinkers enjoy taking an unconventional approach to many aspects of life. They often seek out unlikely paths, mixing willingness to experiment with personal creativity.")

        case "ENFJ":
            return ("ENFJ (Protagonist) is a personality type with the Extraverted, Intuitive, Feeling, and Judging traits. These warm, forthright types love helping others, and they tend to have strong ideas and values. They back their perspective with the creative energy to achieve their goals. When ENFJs care about someone, they want to help solve that person’s problems – sometimes at any cost. The good news is that many people are grateful for this assistance and advice. After all, there’s a reason that these personalities have a reputation for helping others improve their lives. People with the ENFJ personality type (Protagonists) feel called to serve a greater purpose in life. Thoughtful and idealistic, ENFJs strive to have a positive impact on other people and the world around them. These personalities rarely shy away from an opportunity to do the right thing, even when doing so is far from easy.")

        case "ENFP":
            return ("ENFP (Campaigner) is a personality type with the Extraverted, Intuitive, Feeling, and Prospecting traits. These people tend to embrace big ideas and actions that reflect their sense of hope and goodwill toward others. Their vibrant energy can flow in many directions.")

        case "ENTJ":
            return ("ENTJ (Commander) is a personality type with the Extraverted, Intuitive, Thinking, and Judging traits. They are decisive people who love momentum and accomplishment. They gather information to construct their creative visions but rarely hesitate for long before acting on them.")

        case "ENTP":
            return ("ENTP (Debater) is a personality type with the Extraverted, Intuitive, Thinking, and Prospecting traits. They tend to be bold and creative, deconstructing and rebuilding ideas with great mental agility. They pursue their goals vigorously despite any resistance they might encounter.")

        case "INFP":
            return ("INFP (Mediator) is a personality type with the Introverted, Intuitive, Feeling, and Prospecting traits. These rare personality types tend to be quiet, open-minded, and imaginative, and they apply a caring and creative approach to everything they do.")

        case "ISFJ":
            return ("ISFJ (Defender) is a personality type with the Introverted, Observant, Feeling, and Judging traits. These people tend to be warm and unassuming in their own steady way. They’re efficient and responsible, giving careful attention to practical details in their daily lives.")

        case "ESTJ":
            return ("ESTJ (Executive) is a personality type with the Extraverted, Observant, Thinking, and Judging traits. They possess great fortitude, emphatically following their own sensible judgment. They often serve as a stabilizing force among others, able to offer solid direction amid adversity.")

        case "ESFJ":
            return ("ESFJ (Consul) is a personality type with the Extraverted, Observant, Feeling, and Judging traits. They are attentive and people-focused, and they enjoy taking part in their social community. Their achievements are guided by decisive values, and they willingly offer guidance to others.")

        case "ISFP":
            return ("ISFP (Adventurer) is a personality type with the Introverted, Observant, Feeling, and Prospecting traits. They tend to have open minds, approaching life, new experiences, and people with grounded warmth. Their ability to stay in the moment helps them uncover exciting potentials.")

        case "ESTP":
            return ("ESTP (Entrepreneur) is a personality type with the Extraverted, Observant, Thinking, and Prospecting traits. They tend to be energetic and action-oriented, deftly navigating whatever is in front of them. They love uncovering life’s opportunities, whether socializing with others or in more personal pursuits.")

        case "ESFP":
            return ("ESFP (Entertainer) is a personality type with the Extraverted, Observant, Feeling, and Prospecting traits. These people love vibrant experiences, engaging in life eagerly and taking pleasure in discovering the unknown. They can be very social, often encouraging others into shared activities.")

        case _:
            return ("A very special and interesting personality")



name = input("What is your name? ")

e_count = i_count = 0
s_count = n_count = 0
t_count = f_count = 0
j_count = p_count = 0


user_responses = [''] * 20

print(f"\nHello, {name}! Kindly answer each question with 'A' or 'B' to determine your personality.\n")


questions = [
    ["A) Expend energy, enjoy groups", "B) Conserve energy, enjoy one on one"],
    ["A) Interpret literally", "B) Look for meaning and possibilities"],
    ["A) Logical, thinking, questioning", "B) Empathetic, feeling, accommodating"],
    ["A) Organized, orderly", "B) Flexible, adaptable"],
    ["A) More outgoing, think out loud", "B) More reserved, think to yourself"],
    ["A) Practical, realistic, experiential", "B) Imaginative, innovative, theoretical"],
    ["A) Candid, straightforward, frank", "B) Tactful, kind, encouraging"],
    ["A) Plan, schedule", "B) Unplanned, spontaneous"],
    ["A) Seek many tasks, public activities, interaction with others", 
     "B) Seek private, solitary activities with quiet to concentrate"],
    ["A) Standard, usual, conventional", "B) Different, novel, unique"],
    ["A) Firm, tend to criticize, hold the line", "B) Gentle, tend to appreciate, conciliate"],
    ["A) Regulated, structured", "B) Easygoing, 'live and let live'"],
    ["A) External, communicative, express yourself", "B) Internal, reticent, keep to yourself"],
    ["A) Focus on here-and-now", "B) Look to the future, global perspective, 'big picture'"],
    ["A) Tough-minded, just", "B) Tender-hearted, merciful"],
    ["A) Preparation, plan ahead", "B) Go with the flow, adapt as you go"],
    ["A) Active, initiate", "B) Reflective, deliberate"],
    ["A) Facts, things, 'what is'", "B) Ideas, dreams, 'what could be', philosophical"],
    ["A) Matter-of-fact, issue-oriented", "B) Sensitive, people-oriented, compassionate"],
    ["A) Control, govern", "B) Latitude, freedom"]
]


for index in range(len(questions)):
    print(f"Q{index + 1}: {questions[0]}  {questions[1]}")
    response = check_response()
    user_responses[index] = response

  
if index % 4 == 0:
    if response == 'A':
        e_count += 1
    else:
        i_count += 1
elif index % 4 == 1:
    if response == 'A':
        s_count += 1
    else:
        n_count += 1
elif index % 4 == 2:
    if response == 'A':
        t_count += 1
    else:
        f_count += 1
elif index % 4 == 3:
    if response == 'A':
        j_count += 1
    else:
        p_count += 1

mbti = ''
mbti += 'E' if e_count >= i_count else 'I'
mbti += 'S' if s_count >= n_count else 'N'
mbti += 'T' if t_count >= f_count else 'F'
mbti += 'J' if j_count >= p_count else 'P'


print(f"\nHello {name}, you selected:")
print_extrovert_introvert(user_responses, questions)
print_sensing_intuition(user_responses, questions)
print_thinking_feeling(user_responses, questions)
print_judging_perceptive(user_responses, questions)

mbtiDescription = get_MBTI_description(mbti);
print(f"\n{name}, your MBTI type is: {mbti}")
print(f"Description: {mbtiDescription}")








