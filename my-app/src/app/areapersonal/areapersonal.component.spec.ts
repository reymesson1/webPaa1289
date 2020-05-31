import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AreapersonalComponent } from './areapersonal.component';

describe('AreapersonalComponent', () => {
  let component: AreapersonalComponent;
  let fixture: ComponentFixture<AreapersonalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AreapersonalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AreapersonalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
