#include <vector>
#include <iostream>
using namespace std;

template <typename T>
class myStack {
  vector<T> aStack;

 public:
  void push(T c) { aStack.emplace_back(c); }

  bool pop() {
    if (aStack.size()) {
      aStack.pop_back();
      return true;
    }
    return false;
  }

  T top() { return aStack.back(); }
  bool isEmpty() { return aStack.empty(); }
};

bool validParenthesis(string input) {
  myStack<char> stack;

  for (char c : input) {
    if (c == '(') stack.push('(');

    else if (c == ')') {
      if (stack.top() != '(') {
        return false;
      }
      stack.pop();
    }
  }
  return stack.isEmpty();
};

int main() {

    cout << "String please: ";
    string input;
    cin >> input;

    cout << boolalpha << "String has valid parenthesis: " << validParenthesis(input);

}
