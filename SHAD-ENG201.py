import rich
from rich.console import Console

emojis = {
    'correctPlace': '🟩',
    'correctLetter': '🟨',
    'incorrectLetter': '⬜'
}

def correct_place(letter):
  return f'[black on green]{letter}[/]'

def correct_letter(letter):
  return f'[black on yellow]{letter}[/]'

def incorrect_letter(letter):
  return f'[black on white]{letter}[/]'

def score_guess(guess,ans):
  scored = []
  for i, letter in enumerate(guess):
    if ans[i] == guess[i]:
      scored.append(correct_place(letter))
    elif letter in ans:
      scored.append(correct_letter(letter))
    else:
      scored.append(incorrect_letter(letter))
  return "".join(scored)

def main():
  max = 6
  used = 0

  console = Console()
  ans = input("Enter the word to guess:\n")
  ans = ans.upper()
  console.clear()

  all_scored = []
  
  while(used != max):
    used = used + 1

    guess = input("Enter a guess:\n")

    while(len(guess) != len(ans)):
      guess = input("Try again: Enter your guess\n")
      
    guess = guess.upper()
    scored = score_guess(guess,ans)

    all_scored.append(scored)

    for score in all_scored:
      console.print(scored)
      
    if guess == ans:
      break

  if used == max:
    print("\nNo more tries. YOU LOSE!")
  else:
      print(f'\nYOU WIN!\n\nWORDLE {used}/{max}')


if __name__ == '__main__':
  main()
