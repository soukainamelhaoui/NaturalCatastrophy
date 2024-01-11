import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.scss']
})
export class QuestionsComponent implements OnInit {

  items: any[] = [];

  activeIndex: number = 0;

  constructor() { }

  ngOnInit(): void {
      this.items = [{ 
              label: 'Volunteering', icon: 'pi pi-fw pi-info-circle', questions: [
                  'How can I get involved in volunteering?', 'What types of volunteer opportunities are available?', 'How do I find volunteer opportunities in my area?', ' Can I volunteer if I have a busy schedule?'
              ] 
          },
          { 
              label: 'Donations', icon: 'pi pi-fw pi-envelope', questions: [
                  'How can I make a donation to a charity or organization?', 'Are my donations tax-deductible?', 'What items are commonly accepted as donations?', 'How can I add attachements?'
              ] 
          },
          { 
              label: 'Helping Others', icon: 'pi pi-fw pi-question-circle', questions: [
                  'How can I help someone in need in my community?', 'Are there opportunities to help remotely or virtually?', 'How can I encourage others to get involved in helping the community?', 'What happens to the donated blood?'
              ] 
          },
          { 
              label: 'Blood Donation', icon: 'pi pi-fw pi-credit-card', questions: [
                  'Why is blood donation important?', 'Who can donate blood?', 'How often can I donate blood?', 'Is blood donation safe?'
              ] 
          }
      ];
  };

  changeItem(i: number) {
      this.activeIndex = i;
  }
}
